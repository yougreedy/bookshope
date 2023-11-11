 
window.addEventListener("load", function() {
  const buttons = document.querySelectorAll(".password_check");

    buttons.forEach(button => {
        button.addEventListener("mousedown", e => {
       //target은 이벤트 객체의 프로퍼티(property)이며, 이벤트 핸들러 함수 내에서 이벤트를 발생시킨 엘리먼트를 참조하는 객체
            if(e.button == 0) {
                const name = e.target.dataset.for; //button이 가리키고 있는 걸 찾음 , 사용하는 경우 dataset.이름 dataset.for jsp에서 data-이름 "값" data-for="passwd"
                const input = document.querySelector(`input[name='${name}']`);
                input.setAttribute("type", "text");
            }
        });
   
        button.addEventListener("mouseout", e => {
            if(e.button == 0) {
                const name = e.target.dataset.for;
                const input = document.querySelector(`input[name='${name}']`);
                input.setAttribute("type", "password");
            }
        });
    });
});

