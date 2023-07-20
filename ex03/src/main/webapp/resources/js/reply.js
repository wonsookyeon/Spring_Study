/*
    입력완료
 */

    console.log("reply Module");

    var replyService=(function(){
    
    // 댓글삽입
     function add(reply, callback, error){    //replyService.add(vo)
        console.log("reply........");
    
        //비동기 전송
        $.ajax({
    
            type : "post",  //전송할 method type
            url : "/replies/new",  // 보낼 주소
            data : JSON.stringify(reply), //자바객체(reply)를 json형태로 변환
            contentType : "application/json; charset=utf-8", //전송할 type 설정
        
            success : function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error : function(xhr, status, er){
                if(error){
                    error(er);
                }
    
            }
        })
     } //add end

     //댓글 리스트 가져오기 bno
     function getList(param, callback, error){
        let bno = param.bno;
        let page = param.page || 1;  //page 값 없으면 1
    
        $.ajax({
            type : "get",
            url : "/replies/pages/" + bno + "/" + page,
    
            success : function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error : function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
     } //getList end

     //댓글삭제
     function remove(rno, callback, error){

        $.ajax({
            type : "delete",
            url : "/replies/" + rno, 

            success : function(result, status, xhr){
                if(callback) callback(result);
            },
            error : function(er, status, xhr){
                if(error) error(er);
            }

        });
     } // remove end

     //댓글수정
     function update(reply, callback, error){
        $.ajax({
            type : "patch",
            url : "/replies/" + reply.rno,
            data : JSON.stringify(reply),
            contentType : "application/json; charset : utf-8",

            success : function(result, status, xhr){
                if(callback) callback(result);
            },
            error : function(err, status, xhr){
                if(error) error(err);
            }

        });
     } // update end

     //댓글 1건 가져오기 rno
     function get(rno, callback, error){
        $.ajax({
            type : "get",
            url : "/replies/" + rno,
            success : function(result, status, xhr){
                if(callback) callback(result);
            },
            error : function(err, status, xhr){
                if(error) error(err);
            }
        });
     } // get end

     function displayTime(timeValue){
        var today = new Date();

        var gap = today.getTime() - timeValue;

        var dateObj = new Date(timeValue);

        var str = "";

        if(gap < (1000 * 60 * 60 * 24)) { //gap 차이가 하루가 지나면
            var hh = dateObj.getHours();
            var mi = dateObj.getMinutes();
            var ss = dateObj.getSeconds();

                    //두자리수 표기 01~09
            return [(hh>9 ? '' : '0') + hh , ':' ,
                    (mi>9 ? '' : '0') + mi , ':' , 
                    (ss>9 ? '' : '0') + ss
                ].join('');
            }else{
                var yy = dateObj.getFullYear();
                var mm = dateObj.getMonth() + 1; // getMonth() -> zero-based
                var dd = dateObj.getDate();

                return [yy, '/', (mm>9? '' : '0') + mm, '/', (dd>9? '': '0') + dd].join('');
            }
        };
     

     return{
        add : add,
        getList : getList,
        remove : remove,
        update : update,
        get : get,
        displayTime : displayTime
    };
    
    })();
