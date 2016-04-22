function choose(table) {
    var checkbox = $('input[name=ids]:checkbox:checked');
    if (checkbox.size() == 0) {
        alert("请选择修改要查询的列字段");
        return;
    }
    var cols = [];
    checkbox.each(function (index, el) {
        var item = {}, par = $(el).parent();
        item.id = el.value;
        item.columnName = par.next().text();
        item.labelName = par.parent().find('input[type=text]').val();
        item.active = true;
        cols.push(item);
    });

    $.ajax({
        type: 'POST',
        url: '/column/update.do',
        dataType: 'json',
        data: {'table': table, 'cols': JSON.stringify(cols)},
        success: function (response) {

        }
    })
}