package com.daru.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.daru.s1.board.BoardDTO;
import com.daru.s1.board.BoardService;
import com.daru.s1.util.FileManager;
import com.daru.s1.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.total(pager));
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		int result = qnaDAO.add(boardDTO);
		//1 HDD 
		for(int i=0;i<files.length;i++) {
			if(files[i].isEmpty()) {
				continue;
			}
		String fileName	= fileManager.save(files[i], "resources/upload/qna/");
		//2 DB
		QnaFileDTO qnaFileDTO = new QnaFileDTO();
		qnaFileDTO.setNum(boardDTO.getNum());
		qnaFileDTO.setFileName(fileName);
		qnaFileDTO.setOriName(files[i].getOriginalFilename());
		result = qnaDAO.addFile(qnaFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
		List<QnaFileDTO> ar = qnaDAO.listFile(boardDTO);
		int result = qnaDAO.delete(boardDTO);
		
		if(result>0) {
			for(QnaFileDTO dto:ar) {
				boolean check = fileManager.remove("resources/upload/qna", dto.getFileName());
			}
		}
		
		return result;
	}
	
	public int reply(QnaDTO qnaDTO)throws Exception{
		//qnaDTO.num=부모글의 글번호 
		//qnaDTO.title=폼에서 입력한 답글 제목
		//qnaDTO.writer:폼에서 입력한 답글 작성자
		//qnaDTO.contents:폼에서 입력한 답글 내용
		//qnaDTO.regDATE: NULL
		//qnaDTO.hit:0
		//qnaDTO.ref: 0
		//qnaDTO.step: 0
		//qnaDTO.depth: 0
		
		//1. 부모의 정보를 조회(ref, step, depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO; //형변환
		
		//2. 답글의 ref는 부모의 ref값
		qnaDTO.setRef(parent.getRef());
		
		//3. 답글의 step은 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		//4. 답글의 depth는 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//5. step update
		int result = qnaDAO.stepUpdate(parent);
		
		//6. 답글 insert
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}

}
