function addQueryObj(tableName) {
    $.ajax({
        type: 'POST',
        url: '/table/add_qy.do',
        data: {'table_name': tableName},
        success: function(response){
            parent.$.fn.zTree.getZTreeObj("tree").refresh();
        }
    })
}

function removeQueryObj(tableName) {
    $.ajax({
        type: 'POST',
        url: '/table/remove_qy.do',
        data: {'table_name': tableName},
        success: function(response){
            parent.$.fn.zTree.getZTreeObj("tree").refresh();
        }
    })
}

