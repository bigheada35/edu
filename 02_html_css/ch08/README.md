#### CSS기본III
  반응선택자
  상태선택자
  구조선택자
  전체적인 레이아웃설정

#### :hover 반응 선택자
	<stle>
		li:hover{
			color:blue
		}
	</style>
	////////
	<div>
		<ul>
			<li>menu1</li>
#### :focus  상태 선택자
	<style>
		input:focus{	}
#### :enabled 상태 선택자
		input:enabled{ 	}
#### :disabled 상태 선택자
	<style>
		input:disabled{ 	}
	<body>
		<form>
			비밀번호: <input type="password" name="upw" disabled = "disabled" /><br/>
#### :nth-child 	구조 선택자
#### :first-child 	구조 선택자
#### :last-child 	구조 선택자
	ul li:nth-child(2n+1){ 	}
	ul li:first-child{ 	}
	ul li:last-child{ 	}

#### 전체적인 레이아웃설정
	<div>로 화면을 나눌때 
		수직으로 id선택자(#)을 사용해서 나누고
		수직으로는 class선택자(.)을 사용해서 나누기
	
	id 
