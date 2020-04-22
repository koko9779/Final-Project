var eventModal = $('#eventModal');
var modalTitle = $('.modal-title');
var editAllDay = $('#edit-allDay');
var editTitle = $('#edit-title');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editColor = $('#edit-color');
var editDesc = $('#edit-desc');

var addBtnContainer = $('.modalBtnContainer-addEvent');
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');


/* ****************
 *  새로운 일정 생성
 * ************** */
var newEvent = function (start, end, eventType) {

    $("#contextMenu").hide(); //메뉴 숨김

    modalTitle.html('새로운 일정');
    editType.val(eventType).prop('selected', true);
    editTitle.val('');
    editStart.val(start);
    editEnd.val(end);
    editDesc.val('');
    
    addBtnContainer.show();
    modifyBtnContainer.hide();
    eventModal.modal('show');

    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    var eventId = 1 + Math.floor(Math.random() * 1000);
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/

    //새로운 일정 저장버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {

        var eventData = {
           eventId: eventId,
           editTitle: editTitle.val(),
           editStart: editStart.val(),
           editEnd: editEnd.val(),
           editDesc: editDesc.val(),
           editType: editType.val(),
           userName: '관리자',
           editColor: editColor.val(),
           textColor: '#ffffff',
           allDay: false
        };

        if (eventData.editStart > eventData.editEnd) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (eventData.editTitle == '') {
            alert('일정명은 필수입니다.');
            return false;
        }

        var realEndDay;

        if (editAllDay.is(':checked')) {
            eventData.start = moment(eventData.editStart).format('YYYY-MM-DD');
            //render시 날짜표기수정
            eventData.end = moment(eventData.editEnd).add(1, 'days').format('YYYY-MM-DD');
            //DB에 넣을때(선택)
            realEndDay = moment(eventData.editEnd).format('YYYY-MM-DD');

            eventData.allDay = true;
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);
        eventModal.find('input, textarea').val('');
        editAllDay.prop('checked', false);
        eventModal.modal('hide');

        
        console.log("eventData : " + JSON.stringify(eventData));
        //새로운 일정 저장
        console.log($("#edit-title").val());
        $.ajax({
            type: "post",
            url: "create_calendar",
            data:  eventData,
            success: function (response) {
               alert(response.result);
                //DB연동시 중복이벤트 방지를 위한
                //$('#calendar').fullCalendar('removeEvents');
                //$('#calendar').fullCalendar('refetchEvents');
            }
        });
    });
};