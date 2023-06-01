// function enviarPOST() {
//     var http = new XMLHttpRequest();
// // Aqui pondremos donde queremos que se vaya enviando la informacion 
// // (ordenador localhost,port 3000,projecta tomcat,clase Login, true es que me deixa fer coses una vegada enviat, 
// // no necesit esperar a que me contesti)

//     let mail = document.getElementById("mail").value
//     let pass = document.getElementById("pass").value
//     http.open("POST", "http://localhost:3000/Tomcat/Login",true);
//     // peticio des atributs segons es tipus arxiu
//     http.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // si volem cercar es tipos de content-type aquest es per clau-valor
//     // enviam
//     http.send("mail="+mail+"&pass="+pass);

//     http.onreadystatechange = function() {
//         if(this.readyState==4 && this.status==200) {   // es numero 4 es es darrer pas de verificacio i 200 es que ha anat tot be
//             if (this.responseText == "ok") {
//                 document.getElementById("resultat").innerHTML = "Estas loggeado"
//             }

//         }
//     }
// }

function enviar() {
    var http = new XMLHttpRequest();
// Aqui pondremos donde queremos que se vaya enviando la informacion 
// (ordenador localhost,port 3000,projecta tomcat,clase Login, true es que me deixa fer coses una vegada enviat, 
// no necesit esperar a que me contesti)

    let mail = document.getElementById("mail").value
    let pass = document.getElementById("pass").value
    http.open("GET", "http://localhost:8080/DAWFarmacia/Login?mail="+mail+"&pass="+pass,true);
    // peticio des atributs segons es tipus arxiu

    // enviam
    http.send();

    http.onreadystatechange = function() {
        if(this.readyState==4 && this.status==200) {   // es numero 4 es es darrer pas de verificacio i 200 es que ha anat tot be
            let session = this.responseText;
            if (session != "0") {
                window.sessionStorage.setItem("mail",mail);
                window.sessionStorage.setItem("session",session);
                document.getElementById("resultat").innerHTML="Loggin Correcta";

                window.location.href = "/gestio.html"
            } else {
                document.getElementById("resultat").innerHTML="Loggin Incorrecta";
            }

        }
    }
}