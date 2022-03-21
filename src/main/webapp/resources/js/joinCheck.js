const check = document.getElementsByClassName('check');
const checkAll = document.getElementById('checkAll');
const rules = document.getElementById('rules');
const btn = document.getElementById('btn');

checkAll.addEventListener('click', function(){
   
    for(c of check){
        c.checked = checkAll.checked;
    }
});


rules.addEventListener("click", function(event){
        let final = true;
        for(c of check){
            if(!c.checked){
                final=false;
            }
        }
        checkAll.checked = final;
    
});


//for(ch of check){
//    ch.addEventListener("click", function(){
        
//        let final = true;
//        for(c of check){
//            if(!c.checked){
//                final=false;
//            }
//        }
//        checkAll.checked = final;



//    })
// };




btn.addEventListener("click", function(){
    // let c = true;
    // for(ch of check){
    //     if(!ch.checked){
    //         c = false;
    //     }
    // }

    // if(c){
    //     location.href="./join";
    // }else{
    //     alert("약관동의 필요합니다");
    // }


    if(checkAll.checked){
        location.href="./join";
    }else{
        alert("약관동의 필요합니다");
    }


});