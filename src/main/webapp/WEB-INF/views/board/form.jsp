<%--
  Created by IntelliJ IDEA.
  User: mayeye
  Date: 2019-01-21
  Time: 오후 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script>
        // $('#frm').validate({
        //     focusCleanup: true, //true이면 잘못된 필드에 포커스가 가면 에러를 지움
        //     focusInvalid:false, //유효성 검사후 포커스를 무효필드에 둠 꺼놓음
        //     onclick: false, //클릭시 발생됨 꺼놓음
        //     onfocusout:false, //포커스가 아웃되면 발생됨 꺼놓음
        //     onkeyup:false, //키보드 키가 올라가면 발생됨 꺼놓음
        //     rules: {
        //         UserName: { required: true, minlength: 3},
        //         password: { required: true, minlength: 8 },
        //         repassword: { equalTo: "#password"},
        //         phone : { required: true, minlength: 9, phone: true}
        //     },
        //     messages: {
        //         UserName: {
        //             required: "아이디를 입력하세요.",
        //             minlength: jQuery.validator.format("아이디는 {0}자 이상 입력해주세요.")
        //         },
        //         password: {
        //             required: "암호를 입력하시오." ,
        //             minlength: "암호는 8자 이상 입력해주세요."
        //         },
        //         repassword: {
        //             equalTo: "입력하신 암호가 다릅니다."
        //         },
        //         phone: {
        //             required: "연락처를 입력하세요.",
        //             minlength: "연락처는 9자이상 입력해주세요.",
        //             phone: "잘못된 문자가 입력되었습니다."
        //         }
        //     },
        //     errorPlacement: function (){ //validator는 기본적으로 validation 실패시 메세지를 우측에 표시하게 되어있다 원치않으면 입력해놓을것 ★안쓰면 에러표시됨★
        //         console.log("errorPlacement")
        //     },
        //     submitHandler: function(form) { //모든 항목이 통과되면 호출됨 ★showError 와 함께 쓰면 실행하지않는다★
        //         form.submit();
        //     },
        //     invalidHandler: function(form, validator){ //입력값이 잘못된 상태에서 submit 할때 호출
        //         var errors = validator.numberOfInvalids();
        //         if (errors) {
        //             alert(validator.errorList[0].message);
        //             validator.errorList[0].element.focus();
        //         }
        //     }
        // });


    </script>
</head>
<body>
    <form id="frm" action="${pageContext.request.contextPath}/board" method="post">
        <div>
        <label>제목</label> <input type="text" name="title"/>
        </div>
        <div><label>내용</label> <input type="text" name="content"/></div>
        <div><label>이메일</label> <input type="email" id="email" name="email"/></div>
        <div><label>폰</label> <input type="text" name="phone"/></div>
        <input type="submit" value="등록"/>
    </form>
</body>
<script>
    jQuery.validator.addMethod("customEmail", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i.test(value);
    }, "Please enter valid email address!");

    $('#frm').validate({
        errorElement : 'b',
        rules: {
            title : { required: true, minlength: 3},
            content: { required: true, minlength: 8 },
            email : {required:true , customemail:true},
            phone: {required:true, phone:true}
        },
        messages: {
            title: {
                required: "제목을 입력하세요.",
                minlength: jQuery.validator.format("제목 {0}자 이상 입력해주세요.")
            },
            content: {
                required: "내용을 입력하세요.",
                minlength: jQuery.validator.format("내용은 {0}자 이상 입력해주세요.")
            },
            email:{
                required: "이메일을 입력하세여."
            },
            phone:{
                required:"핸드폰번호를 입력하세요.",
                phone:true
            }
        },
        // errorPlacement: function (){ //validator는 기본적으로 validation 실패시 메세지를 우측에 표시하게 되어있다 원치않으면 입력해놓을것 ★안쓰면 에러표시됨★
        //     console.log("errorPlacement")
        // },
        submitHandler: function(form) { //모든 항목이 통과되면 호출됨 ★showError 와 함께 쓰면 실행하지않는다★
            form.submit();
        },
        invalidHandler: function(form, validator){ //입력값이 잘못된 상태에서 submit 할때 호출
            var errors = validator.numberOfInvalids();
            if (errors) {
                alert(validator.errorList[0].message);
                validator.errorList[0].element.focus();
            }
        }
    });
</script>
</html>
