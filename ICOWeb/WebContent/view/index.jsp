<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ICO在线小工具</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="ICO在线转换小工具">
    <meta name="key" content="ICO,在线,转换,小工具">
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

    <!-- 头部 navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
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
            <li class="active"><a href="#">主页</a></li>
            <li><a href="#about">关于</a></li>
            <li><a href="#contact">联系</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">其它 <span class="caret"></span></a>
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
        <!--文件信息-->
        <div>
            <div class="row">
              <div class="form-group col-sm-6">
                    <label class="control-label col-sm-2" style="margin-top: 8px;">上传尺寸:</label>
                    <div class="col-sm-4">
                      <select id="size" class="form-control" name="size">
                          <option value=128 selected="selected">128X128</option>
                          <option value=64>64X64</option>
                          <option value=32>32X32</option>
                          <option value=16>16X16</option>
                          <option value="all">全尺寸</option>
                      </select>
                    </div>
             </div>
            </div>
             <!--要支持单文件上传与多文件上传的操作方式-->
        </div>
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

      <div class="row">
        <div class="col-sm-6" style="margin:o auto;">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">注意事项</h3>
            </div>
            <div class="panel-body">
                <ul>
                  <li>Cras justo odio</li>
                  <li>Dapibus ac facilisis in</li>
                  <li>Morbi leo risus</li>
                  <li>Porta ac consectetur ac</li>
                  <li>Vestibulum at eros</li>
                </ul>
            </div>
          </div>
        </div>
        
        <div class="col-sm-6">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">说明</h3>
            </div>
            <div class="panel-body">
                <div class="well">
		        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam eget risus varius blandit sit amet non magna. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Cras mattis consectetur purus sit amet fermentum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Aenean lacinia bibendum nulla sed consectetur.</p>
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