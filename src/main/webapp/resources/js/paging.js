$(function () {
    var pageNum = $("#pageNum").val();
    var pages = $("#pages").val();
    var options = {
        bootstrapMajorVersion:3,    //设置 Bootstrap 版本
        size:"normal",   //设置控件的显示大小,允许的值: mini（mini版的）, small（小号的）, normal（正常的）,large（大号的）
        alignment:"center ",   //设置控件的对齐方式,允许的值用： left, center andright
        currentPage: pageNum, //设置当前页
        numberOfPages:5,    //设置控件显示的页码数
        totalPages: pages,  //设置总页数
        pageUrl:function(type, page, current){ //设置超链接的链接地址
            return "javascript:void(0)";
        },
        itemTexts:function (type, page, current){   //控制每个操作按钮的显示文字
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        },
        onPageClicked:function (event, originalEvent, type, page){  // click 事件
            $("#pageNum").val(page);
            $("#queryForm").submit();
        }
    }
    $('#paging').bootstrapPaginator(options);
})