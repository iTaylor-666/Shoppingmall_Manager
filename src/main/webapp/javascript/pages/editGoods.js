
let editGoodsId = sessionStorage.getItem("editGoodsId")
$(function () {
    $("#goodsId").val(editGoodsId)
    fillTopType()
    findBrandList()
    findEditGoods()
})

function findEditGoods(){
    $.ajax({
        url:"goods/selOne",
        data:{
            goodsId:editGoodsId
        },
        dataType:"json",
        success:function (result) {
            if(result.data != null){
                //layer.msg(JSON.stringify(result.data),{time:5000})
                let goods = result.data
                $("#goodsNo").val(goods.goodsNo)
                $("#goodsName").val(goods.goodsName)

                let typeIds = goods.goodsTypeIds;
                //选择顶级类别
                $("#goodsTypeDiv>select>option[value="+typeIds[typeIds.length-1]+"]").attr("selected","selected")
                layui.form.render()
                //查找顶级类别下的子类别
                addChildType(typeIds[typeIds.length-1])
                let childIndex = 1;
                for (let i = typeIds.length-2; i >=0 ; i--) {
                    $("#goodsTypeFather select:eq("+childIndex+")>option[value="+typeIds[i]+"]").prop("selected","selected")
                    layui.form.render()
                    addChildType(typeIds[i])
                }

                //选择商品品牌
                // $("#goodsBrand>option[value="+goods.goodsBrand+"]").prop("selected","selected")
                // layui.form.render()
                $("#goodsBrand").val(goods.goodsBrand)

                //价格回显
                $("#goodsPrice").val(goods.goodsPrice)

                //单位回显
                $("#goodsUnits").val(goods.goodsUnits)

                //折扣回显
                $("#goodsDiscount").val(goods.goodsDiscount)

                //库存数量回显
                $("#repertoryNum").val(goods.repertoryNum)

                //生产日期回显
                $("#createDate").val(goods.createDate)

                //截止日期回显
                $("#deadDate").val(goods.deadDate)

                //回显主图
                $("#mainImg").prop("src",goods.mainImage)

                //回显细节图
                $("#detailImg").append(`<img src="${goods.image1}" style="width:100px;height: 100px;margin-left: 15px;">`)
                $("#detailImg").append(`<img src="${goods.image2}" style="width:100px;height: 100px;margin-left: 15px;">`)
                $("#detailImg").append(`<img src="${goods.image3}" style="width:100px;height: 100px;margin-left: 15px;">`)
                $("#detailImg").append(`<img src="${goods.image4}" style="width:100px;height: 100px;margin-left: 15px;">`)
            }
        }
    })
}

//查询品牌列表
function findBrandList(){
    $.ajax({
        url:"goods/brandList",
        dataType: "json",
        async:false,
        success:function (result) {
            // console.log(result)
            let brandList = result.data;
            let optionStr = `<option value="">请选择商品品牌</option>`
            for (let i = 0; i < brandList.length; i++) {
                optionStr += `<option value="${brandList[i]}">${brandList[i]}</option>`
            }
            $("#goodsBrand").html(optionStr)
            layui.form.render()
        }
    })
}

//填充顶级商品类别
function fillTopType(){
    let typeStr = findGoodsTypeList(0)
    $("#goodsTypeDiv>select").html(typeStr)
}

//查询商品类别列表
function findGoodsTypeList(parentId){
    let goodsTypeStr=''

    $.ajax({
        url:"type/list",
        data:{
            parentId:parentId
        },
        dataType: "json",
        async:false,
        success:function (result) {
            let typeList = result.data;
            if(typeList.length>0){
                if(parentId==0){
                    goodsTypeStr=`<option value="">请选择商品类别</option>`
                }else{
                    goodsTypeStr=`<option value="">请选择商品子类</option>`
                }
                for (let i = 0; i < typeList.length; i++) {
                    goodsTypeStr += `<option value="${typeList[i].goodsTypeId}">${typeList[i].typeName}</option>`
                }
            }
        }
    })
    return goodsTypeStr
}

function addChildType(goodsTypeId){
    let goodsTypeStr =  findGoodsTypeList(goodsTypeId)

    if(goodsTypeStr != ''){
        $("#goodsTypeFather").append(`
					<div class="layui-input-block" style="width: 150px;float: left;margin-left: 10px;">
						<select lay-filter="changeType"  lay-verify="required" >${goodsTypeStr}</select>
					</div>
				`)
        layui.form.render()
    }else{
        $("#goodsTypeFather>.layui-input-block:last>select").prop("name","goodsTypeId")
    }
}