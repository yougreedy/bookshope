let checkId = false;//어디서나 사용이 가능함 checkId 전역변수 선언

window.addEventListener("load", () => {
 
    const button = document.getElementById("check_id");
    const button_sysnc = document.getElementById("check_id_sync");

   //[비동기중복확인]
   button.addEventListener("click", () => {

    const id = document.querySelector("input[name = 'custid']").value;

    const xhr = new XMLHttpRequest(); // 웹 개발에서 AJAX(Asynchronous JavaScript and XML) 요청을 보내기 위해 사용되는 XMLHttpRequest 객체를 생성하는 코드
   
    xhr.open("GET", `checkId/${id}`,true);//open 메서드를 사용하여 요청을 설정합니다. 첫 번째 인자는 요청 메서드(GET.POST)를 지정하는데, 이 경우 GET 요청을 보내고자 합니다. 
//두 번째 인자는 서버의 URL을 지정합니다. URL은 백틱()을 사용하여 동적으로 생성된 checkId/${id}로 지정되어, ${id}부분은 변수id`의 값에 따라 동적으로 결정
   
//onreadystatechange는 XMLHttpRequest 객체의 이벤트 핸들러(Event Handler) 중 하나로, 서버로부터 응답을 받거나 상태가 변할 때 호출되는 콜백 함수를 정의합니다. 
//이벤트 핸들러는 일반적으로 비동기적인 AJAX 요청에서 사용
   xhr.onreadystatechange = () =>{//xhr.onreadystatechange은 XMLHttpRequest 객체의 상태(state)가 변경될 때 호출되는 콜백 함수를 정의하는 부분
       if(xhr.readyState == xhr.DONE){//xhr.readyState XMLHttpRequest 객체의 현재 상태를 나타내는 속성입니다. 이 상태는 0부터 4까지의 숫자 값을 가집니다.
                                     // 이 코드에서는 xhr.DONE (상태 4)을 사용하여 요청이 완료   
        if(xhr.status == 200){//xhr.status는 서버로부터 받은 HTTP 응답 상태 코드를 나타내는 속성입니다. 일반적으로 200은 "OK"를 의미하며, 성공적인 응답
             
               if(xhr.responseText === "OK"){//이 부분은 XMLHttpRequest 객체가 받은 응답을 확인합니다. 받은 응답이 "OK"인지 확인하여 조건을 결정합니다.
                  checkId = true;
                  alert("사용이 가능한 아이디 입니다.")
                }else {
                    alert("다른 사용자가 이미 사용한 아이디 입니다.")
                }
            }       
       }
    };


    xhr.send();//send 메서드를 호출하여 실제 요청을 서버로 보냅니다. 
//이 메서드를 호출함으로써 브라우저는 서버에 GET 요청을 보내고, 서버는 해당 요청에 대한 응답을 반환 
});


    //[동기중복확인]
    button_sysnc.addEventListener("click", () => {

        const id = document.querySelector("input[name = 'custid']").value;

        const xhr = new XMLHttpRequest(); // 웹 개발에서 AJAX(Asynchronous JavaScript and XML) 요청을 보내기 위해 사용되는 XMLHttpRequest 객체를 생성하는 코드
       
        xhr.open("GET", `checkId/${id}`,false);//open 메서드를 사용하여 요청을 설정합니다. 첫 번째 인자는 요청 메서드(GET.POST)를 지정하는데, 이 경우 GET 요청을 보내고자 합니다. 
//두 번째 인자는 서버의 URL을 지정합니다. URL은 백틱()을 사용하여 동적으로 생성된 checkId/${id}로 지정되어, ${id}부분은 변수id`의 값에 따라 동적으로 결정



        xhr.send();//send 메서드를 호출하여 실제 요청을 서버로 보냅니다. 
   //이 메서드를 호출함으로써 브라우저는 서버에 GET 요청을 보내고, 서버는 해당 요청에 대한 응답을 반환 
   
            if(xhr.responseText === "OK"){//이 부분은 XMLHttpRequest 객체가 받은 응답을 확인합니다. 받은 응답이 "OK"인지 확인하여 조건을 결정합니다.
                checkId = true;
                alert("사용이 가능한 아이디 입니다.")
            }else {
                alert("다른 사용자가 이미 사용한 아이디 입니다.")
            }
    });
});