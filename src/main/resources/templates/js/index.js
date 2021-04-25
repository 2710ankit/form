
function getfun(){
    var xhr= new XMLHttpRequest();
    xhr.open("GET","http://localhost:8080/mainpage",true);
    xhr.onreadystatechange=function (){
         if(this.readyState==4 && this.status==200){
            var data=JSON.parse(xhr.responseText);
            console.log(data.length);
            for(var i=0;i<data.length;i++){
                showall(data[i]);
                console.log(data[i]+"-");
             }
             console.log(this.responseText);
         }
         else
             console.log(this.readyState);
    }
    xhr.send();
}

function fun(){
    var name1=document.getElementById('name').value;
    var mobile=document.getElementById('mobileNumber').value;
    var email=document.getElementById('email').value;
    if(name1 == "" || mobile == "" || email==""){
        alert("All fields are mandatory");

        return;
    }

    // var xhr = new XMLHttpRequest();
    // xhr.open("POST","http://localhost:8080/mainpage/findByEmail", true)
    // xhr.onreadystatechange = function (){
    //     if(this.readyStage==4 && this.status==400){
    //         console.log(this.responseText);
    //     }
    //     else {
    //         console.log(this.readyState);
    //     }
    // }
    // console.log(typeof email+"typo");
    // xhr.send(JSON.stringify(email));
    // var funResponse=xhr.responseText;









    // if(funResponse==true)
    // {
        var xhr1 = new XMLHttpRequest();
        xhr1.open("POST", "http://localhost:8080/mainpage", true);

        xhr1.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                console.log(name1);
                console.log("post req success");
            } else
                console.log(this.readyState);
        }
        var json = {
            "name": name1,
            "mobile_no": mobile,
            "email": email,
        }


        xhr1.send(JSON.stringify(json));
        viewdata(name1, email, mobile);
    // }
    // else{
    //     alert("this email is already taken");
    // }

}


function showall(list){
    var name=list.name;
    var email=list.email;
    var mobile=list.mobile_no;
    viewdata(name, email, mobile)
}





function viewdata( name, email, mobile){
    var table=document.getElementById('table');

        var row= document.createElement('tr');
        var data1= document.createElement('td');
        var data2= document.createElement('td');
        var data3= document.createElement('td');
        var data4= document.createElement('td');
        var div=document.createElement('div');

        div.setAttribute("id","blockDiv");
        div.innerHTML=email;
        data1.innerHTML=name;
        data2.innerHTML=mobile;
        data3.appendChild(div);
        data4.innerHTML="<button onclick=del(this) style='height:18px; background-color: antiquewhite;'>Delete</button>";

        console.log(email);
        console.log(name);
        console.log(mobile);

        row.appendChild(data1);
        row.appendChild(data2);
        row.appendChild(data3);
        row.appendChild(data4);
        table.appendChild(row);

}



function del(delBtn){
   var email= delBtn.parentNode.parentNode.querySelector("#blockDiv").innerHTML;
    console.log(email);

        //no clue what to put here?
        var p=delBtn.parentNode.parentNode;
        p.parentNode.removeChild(p);


    var xhr=new XMLHttpRequest()
    xhr.open("DELETE","http://localhost:8080/mainpage",true);
    xhr.onreadystatechange = function (){
        if(this.readyState==4 && this.status==400) {
            console.log("delete method");
        }
    }
    xhr.send(email);


}