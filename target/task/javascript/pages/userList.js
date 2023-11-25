//当前页
let currentPage = 1;
//每页显示条数
let pageSize = 15;
//总页数
let pageCount = 1;

$(function(){
    findUserList();


    //查询按钮事件
    $("#searchGoods").click(function () {
        findGoodsList()
    })

})

function findUserList(){
    $("#loading").show()
    $.ajax({
        url:"user/list",
        dataType:"json",
        data:$("#searchForm").serialize()+"&currentPage="+currentPage+"&pageSize="+pageSize,
        success:function(result){
            $("#userlist").empty()
            var list = result.data.list
            pageCount = result.data.pages
            for (let i = 0; i < list.length; i++) {
                $("#userlist").append
                (`
                    <tr class="cen">
                        <td><a href="#">${list[i].userId}</a></td>
                        <td><a href="#">${list[i].userAcc}</a></td>
                        <td>${list[i].userName}</td>
                        <td>${list[i].registerDate}</td>
                    </tr>
                `)
            }
            $("#loading").hide()
            initPage();
        }
    })
}

function initPage(){
    $(".pagination").createPage({
        pageCount:pageCount,
        current:currentPage,
        backFn:function(p){
            console.log(p);
        }
    });
}

//点击页码
$(document).on("click",".tcdNumber",function(){
    currentPage = $(this).text()
    findUserList()
})

//上一页
$(document).on("click",".prevPage",function () {
    currentPage--
    findUserList()
})

//下一页
$(document).on("click",".nextPage",function () {
    currentPage++
    findUserList()
})



//删除商品
$(document).on("click","#delUser",function () {
    let userId = $(this).attr("userId")
    layer.confirm('确定删除？', {
        title:'系统提示',
        icon: 0,
        shade: 0.3,
        btn: ['确定','取消'],
        btn1:function(index){
            $.ajax({
                url:"user/del",
                data:{
                    userId:userId
                },
                dataType:"json",
                success:function (result) {
                    if(result.data>0){
                        layer.msg("删除成功",{icon:1,time:1000})
                        layer.close(index)
                        console.log($(this))
                        findUserList();
                    }else{
                        layer.msg("删除失败",{icon:1,time:1000})
                    }
                }
            })
        }
    });
})

