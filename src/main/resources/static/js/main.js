$(function(){

    const appendTask = function(data){
        var taskCode = '<h4>' + data.caption + '</h4>' +
            'Описание: ' + '<br>' + data.explanation;
        $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

    $('#show-add-task-form').click(function () {
        $('#task-form').css('display', 'flex');

    });

    $('#task-form').click(function(event){
        if (event.target === this) {
            $(this).css('display', 'none');
        }
    });

    $('#save-task').click(function()
    {
        var data = $('#task-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/tasks/',
            data: data,
            success: function(response)
            {
                $('#task-form').css('display', 'none');
                var task = {};
                task.id = response.id;
                var dataArray = $('#task-form form').serializeArray();
                for (i in dataArray){
                    task[dataArray[i]['caption']] = dataArray[i]['value'];
                }
                appendTask(task);
            }
        });
        return false;
    });
});