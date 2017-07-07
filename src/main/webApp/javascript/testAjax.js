/**
 * 原生Js实现异步Ajax
 */
var getXHR = function(){
    if(window.ActiveXObject){ //对IE6版本的支持
        return new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){
        return new XMLHttpRequest();
    }else{
        return null;
    }
};

var ajax = {
  get:function (url,fn) {
      var xhp = getXHR(); // XMLHttpRequest对象用于在后台与服务器交换数据
      //第三个参数代表是否异步处理
      xhp.open('GET', url, true);
      xhp.onreadystatechange = function () {
          // readyState==4说明请求已完成 304指未修改
          if(xhp.readyState == 4 && (xhp.status == 200 || xhp.status == 304)){
              fn.call(this,xhp.responseText);
          }
      };
      xhp.send(null);
  },
  post:function(url,data,fn){
      var xhp = getXHR();
      xhp.open('POST', url, true);
      xhp.setRequestHeader("Content-type", "application/json"); // 发送信息至服务器时内容编码类型
      xhp.onreadystatechange = function(){
          if(xhp.readyState == 4 && (xhp.status == 200 || xhp.status == 304)){
              fn.call(this,xhp.responseText);
          }
      };
      xhp.send(data);
  }

};

var getResponseText = function(text){
    console.info(typeof text,text);
    var errorSpan = document.getElementById("errorMessage");
    if(text){
        var dataArray = text.split(":");
        console.info(dataArray);
        errorSpan.style.color = dataArray[0];
        errorSpan.innerHTML = dataArray[1] ;
    }
};

//获取项目根路径的方法
var getRootPath = function(){
    //获取当前网址
    var currentUrl = window.document.location.href;
    //获取主机地址之后的目录，如： /uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=currentUrl.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=currentUrl.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
};

var sendMessage = function(){
    var url = getRootPath() + "/api/get-practice/check-message-name";
    var nameInput = document.getElementById("name");
    var errorSpan = document.getElementById("errorMessage");
    console.info(url);
    if(nameInput.value){
        url = url + "?name=" + nameInput.value;
        ajax.get(url,getResponseText);
    }else{
        errorSpan.style.color = 'red';
        errorSpan.innerHTML = '消息名称不能为空！';
    }
};
/**********************************************原生js实现ajax结束*********************************************************/

/**
 *使用Jquery实现ajax
 * todo:jquey的ajax中的dataType属性不设置或设置为非'text'会报parsererror错误
 */
$(document).ready(function(){
    var callBack = function(text){
        console.info(typeof text,text);
        var errorSpan = document.getElementById("error");
        if(text){
            var dataArray = text.split(":");
            console.info(dataArray);
            errorSpan.style.color = dataArray[0];
            errorSpan.innerHTML = dataArray[1] ;
        }
    };

    $("#messageName").on('change',function(event){
        var url = getRootPath() + "/api/get-practice/check-message-name?name=" + event.target.value;
        console.info(url);
        $.ajax({
            url:url,
            type:'GET',
            dataType:'text',
            success:function(data,textStatus){
                console.info(data,textStatus);
                callBack(data);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                console.info(textStatus);
            }
        });
    });
});

