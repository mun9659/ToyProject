window.addEventListener("DOMContentLoaded", function() {
	const submitBtn = document.getElementById("submitBtn");
	
	if(submitBtn) {
		submitBtn.addEventListener("click", () => {
			
			let data = {
				username : document.getElementById("username").value,
				password : document.getElementById("password").value,
				email : document.getElementById("email").value
			}
			
			// console.log(data); // 주석처리
			
			// ajax를 위한 XMLHttpRequest
			const xhr = new XMLHttpRequest();
			xhr.open('POST', "/toy/api/join"); // 요청방식과 URL
			xhr.responseType='json'; // 응답한 데이터를 Json으로 받도록 설정
			xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8'); // 보내는 데이터가 어떤 방식인지 설정
			xhr.send(JSON.stringify(data)); // 데이터를 보내기(여기서 JSON으로 변환)
			
			// 응답하여 갖고온 데이터 확인
			xhr.onload = () => {
				const data = xhr.response;
				if(data.success == true) {
					alert(data.message);
					location.href = "/toy/main";
				} else {
					alert(data.message);
				}
 			}
		});
	}
});