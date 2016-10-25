<html>
<body>
<script>
    function getFile(type) {
        if(!type) type = 'pdf';

        performGetRequest('application/resourcename-v1+' + type, function(result) {
            var blob = new window.Blob([result.response], {type: 'application/' + type});

            var isIE = /*@cc_on!@*/false || !!document.documentMode;
            if (isIE) {
                window.navigator.msSaveOrOpenBlob(blob, 'sample.' + type);
            } else {
                var fileURL = window.URL.createObjectURL(blob);
                window.open(fileURL, '_blank');
            }
        });
    }

    function performGetRequest(acceptHeader, fn) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET","/rest/resourcename");
        xhr.setRequestHeader("Accept",acceptHeader);
        xhr.responseType = "blob";
        xhr.addEventListener('load', function(event) {
            if (xhr.status >= 200 && xhr.status < 300) {
                console.log('successfully got ' + xhr.responseType);
                fn(xhr);
            } else {
                console.warn(xhr.statusText, xhr.responseText);
            }
        });
        xhr.send();
    }

</script>
<h1>Hello Mimetype Junkie!</h1>
<p>What would you like to do?</p>
<p>
    <a href="#" onclick="getFile('pdf')">Get resource as pdf</a><br>
    <a href="#" onclick="getFile('xls')">Get resource as xls</a><br>
    <a href="#" onclick="getFile('csv')">Get resource as csv</a><br>
</p>
</body>
</html>