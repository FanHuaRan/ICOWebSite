<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ICO在线小工具</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="ICO在线小工具">
    <meta name="author" content="范华燃">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--WepUploader core css-->
    <link rel="stylesheet" type="text/css" href="css/webuploader.css" />
    <!-- Custom styles this site-->
    <link  href="css/style.css" rel="stylesheet" />
     <!-- Custom styles for this bootstrap template -->
    <link href="css/sticky-footer-navbar.css" rel="stylesheet">

 </head>

 <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">ICO在线小工具</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <!-- Begin page content -->
    <div class="container">
    	   <!--文件区-->
	       <div id="wrapper">
	        <div id="container">
	            <!--头部，相册选择和格式选择-->

	            <div id="uploader">
	                <div class="queueList">
	                    <div id="dndArea" class="placeholder">
	                        <div id="filePicker"></div>
	                        <p>或将文件拖到这里，最多可选300个文件</p>
	                    </div>
	                </div>
	                <div class="statusBar" style="display:none;">
	                    <div class="progress">
	                        <span class="text">0%</span>
	                        <span class="percentage"></span>
	                    </div><div class="info"></div>
	                    <div class="btns">
	                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
	                    </div>
	                </div>
	            </div>
		        </div>
		    </div>
    </div>

    <div class="footer">
      <div class="container">
        <p class="text-muted">Copyright (c) 2017 范华燃</p>
      </div>
    </div>


    <!-- Bootstrap core JavaScript
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!--WepUploader core javaScript-->
 	 <script type="text/javascript" src="js/webuploader.js"></script>
 	<!--Uploader self javaScript-->
    <script type="text/javascript" src="js/upload.js"></script>
  </body>
</html>