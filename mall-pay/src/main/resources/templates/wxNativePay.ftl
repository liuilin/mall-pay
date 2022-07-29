<!DOCTYPE html>
<html>
<head>
  <title>basic example</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/qrcodejs/1.0.0/qrcode.js"></script>

<p>Render in table</p>
<div id="qrcodeTable"></div>
<p>Render in canvas</p>
<div id="qrcodeCanvas"></div>
<script>
  jQuery('#qrcodeCanvas').qrcode({
    text: "${codeUrl}"
  });
</script>
</body>
</html>