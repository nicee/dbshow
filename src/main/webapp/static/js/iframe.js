var zTree;
var funcIframe;

var setting = {
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: ""
        }
    },
    callback: {
        beforeClick: function (treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("tree");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
                zTree.selectNode(zTree.getNodeByParam("id", treeNode.id));
                funcIframe.attr("src", treeNode.url);
                return false;
            } else {
                funcIframe.attr("src", treeNode.url);
                return true;
            }
        }
    }
};

$(document).ready(function () {
    var t = $("#tree");
    var zNodes = getNodes();
    t = $.fn.zTree.init(t, setting, zNodes);
    funcIframe = $("#funcIframe");
    funcIframe.bind("load", loadReady);
    var zTree = $.fn.zTree.getZTreeObj("tree");
    if (zNodes.length > 0) {
        zTree.selectNode(zTree.getNodeByParam("id", zNodes[0].id));
        funcIframe.attr("src", zNodes[0].url);
    }
});

function loadReady() {
    var bodyH = funcIframe.contents().find("body").get(0).scrollHeight,
        htmlH = funcIframe.contents().find("html").get(0).scrollHeight,
        maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
        h = funcIframe.height() >= maxH ? minH : maxH;
    if (h < 530) h = 530;
    funcIframe.height(h);
}

function getNodes() {
    var nodes;
    $.ajax({
        url: "/menu/menus.do",
        type: "post",
        async: false,
        dataType: "json",
        success: function (result) {
            nodes = result;
        },
        error: function (data, textstatus) {
            alert("获取功能树失败");
        }

    });
    return nodes;
}