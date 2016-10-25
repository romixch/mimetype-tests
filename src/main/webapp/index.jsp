<html>
<body>
<script>
    function getFile(fileExtension, type) {
        if(!fileExtension) fileExtension = 'pdf';
        if(!type) type = 'pdf';

        performGetRequest('application/resourcename-v1+' + type, function(result) {
            var blob = new window.Blob([result.response], {type: 'application/' + type});

            var isIE = /*@cc_on!@*/false || !!document.documentMode;
            if (isIE) {
                window.navigator.msSaveOrOpenBlob(blob, 'sample.' + fileExtension);
            } else {
                var fileURL = window.URL.createObjectURL(blob);
                window.open(fileURL);
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
    Using special mime types:<br>
    <a href="#" onclick="getFile('pdf', 'pdf')">Get resource as pdf</a><br>
    <a href="#" onclick="getFile('xls', 'msexcel')">Get resource as xls</a><br>
    <a href="#" onclick="getFile('csv', 'csv')">Get resource as csv</a><br>
</p>

<p>
    Using official mime types:<br>
    <a href="/rest/simple/pdf">Get pdf</a><br>
    <a href="/rest/simple/xls">Get xls</a><br>
    <a href="/rest/simple/csv">Get csv</a><br>
</p>
</body>
</html>