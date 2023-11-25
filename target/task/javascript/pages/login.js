$(function(){
  fillAccPwd()
  $('#entry').click(function(){
    if($('#adminName').val()==''){
      $('.mask,.dialog').show();
      $('.dialog .dialog-bd p').html('请输入管理员账号');
    }else if($('#adminPwd').val()==''){
      $('.mask,.dialog').show();
      $('.dialog .dialog-bd p').html('请输入管理员密码');
    }else{
      $('.mask,.dialog').hide();
//登入
      $.ajax({
        url:"manager/login",
        data:$("#loginForm").serialize(),
        method:"post",
        dataType:"json",
        success:function (result) {
          if(result.code=="20041"){
            // alert("登入成功")
            layer.msg("登入成功",{icon:1,time:1000},function () {
              localStorage.setItem("user",JSON.stringify(result.data))
              location.href="index.html"
            })
          }else{
            layer.alert('账号或密码错误', { icon: 2, title: '登入提示'})
          }
        }
      })
    }
  });
  $("#saveAccAndPwd").click(function () {
    if($("#saveAccAndPwd").prop("checked")){
      localStorage.setItem("acc",$("#adminName").val())
      localStorage.setItem("pwd",$("#adminPwd").val())
    }else{
      localStorage.removeItem("acc")
      localStorage.removeItem("pwd")
    }
  })
});
//判断是否有记住密码，有点话就填充
function fillAccPwd(){
  let acc = localStorage.getItem("acc")
  let pwd = localStorage.getItem("pwd")
// alert(acc+"--"+pwd)
  if(acc != null && pwd != null){
    $("#adminName").val(acc)
    $("#adminPwd").val(pwd)
    $("#saveAccAndPwd").prop("checked",true)
  }
}