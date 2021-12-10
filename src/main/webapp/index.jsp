<%--
  Created by IntelliJ IDEA.
  User: ipang
  Date: 2021/11/18
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hans-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <c:url var="base" value="/"></c:url>
    <base href="${base}">
    <title>东北林业大学计算机科学与技术</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
          integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/footer.css">
</head>

<body>
<%@ include file="include/header.jsp"%>

<div id="content-box-1">
    <div class="carousel">
        <div id="carouselExampleIndicators" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <!-- Points -->
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                        class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                        aria-label="Slide 4"></button>
            </div>
            <!-- Images -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://tc.qn.ipangbo.cn/image/Carouselmmexport1636790404614.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="https://tc.qn.ipangbo.cn/image/Carousel20211023shuangjiang.gif" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="https://tc.qn.ipangbo.cn/image/Carousel20211107lidong.gif" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="https://tc.qn.ipangbo.cn/image/Carousel20211122xiaoxue.gif" class="d-block w-100" alt="...">
                </div>
            </div>
            <!-- Controller -->
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <div class="core" id="content-core-1">
        <div class="model-box">
            <div class="model-box-header">
                <i class="mdui-icon material-icons">fiber_new</i>
                <span class="model-label">计科新闻</span>
                <span><a href="contents/news/" id="news-more-button">进入新闻网</a></span>
            </div>
            <div class="horizon"></div>
            <div class="model-box-content" id="news-box-content">
                <ul>
                    <li>
                        <a href="contents/news/article?aid=1" class="article-title">关于组织收看《2017 年度 CCCV
                            “心血管OCT易损斑块识别”人工智能专题竞赛》的通知</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <a href="contents/news/article?aid=1" class="article-title">关于开除庞石薄等一名同学的通知</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <a href="contents/news/article?aid=1" class="article-title">诚信考试，回家过年——计科专业严抓考试纪律，扎实把好育人关</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <a href="contents/news/article?aid=1" class="article-title">计科专业党支部开展“以史为鉴”专题诚信教育活动</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <a href="contents/news/article?aid=1" class="article-title">我专业2019级计科四班团支部荣获全国“先进团支部”称号</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                </ul>
            </div>

        </div>
        <div class="model-box">
            <div class="model-box-header">
                <i class="mdui-icon material-icons">memory</i>
                <span class="model-label">专业简介</span>
            </div>
            <div class="horizon"></div>
            <div class="model-box-content" id="intor-box-content">
                <img src="https://tc.qn.ipangbo.cn/image/intro.png" alt="专业介绍图片" id="intro-pic">
                <p>计算机科学与技术系始建于1988年的微机应用专业。1995年在原专业基础上建立了“计算机科学与技术系”。“十一五”期间计算机专业被批准为黑龙江省重点专业建设点和东北林业大学优势专业。2019年通过工程教育专业认证，同年评为黑龙江省一流专业建设点，
                    2020年评为国家级一流本科专业建设点</p>
                <a href="contents/major/">>>查看更多</a>
            </div>
        </div>
    </div>
</div>
<div id="content-box-2">
    <div class="core" id="content-core-2">
        <div class="model-box" id="notice-box">
            <div class="model-box-header">
                <i class="mdui-icon material-icons">notifications</i>
                <span class="model-label">通知公告</span>
                <a href="contents/notice/" id="notice-more-button">>>查看更多</a>
            </div>
            <div class="horizon"></div>
            <div class="model-box-content" id="notice-box-content">
                <ul>
                    <li>
                        <span>[教育教学]</span>
                        <a href="contents/notice/detail?aid=1" class="article-title">关于禁止校外外卖的通告</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <span>[教育教学]</span>
                        <a href="contents/notice/detail?aid=1" class="article-title">关于庞礴等14名预备党员同志转正的公示</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <span>[教育教学]</span>
                        <a href="contents/notice/detail?aid=1" class="article-title">《正告东北农业大学贴吧》</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <span>[教育教学]</span>
                        <a href="contents/notice/detail?aid=1" class="article-title">关于组织学生退出“林大集市”的通知</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                    <li>
                        <span>[教育教学]</span>
                        <a href="contents/notice/detail?aid=1" class="article-title">关于做好庞礴同学后勤保障工作的要求</a>
                        <span class="article-time">2021-11-24</span>
                    </li>
                </ul>
            </div>

        </div>
        <div class="model-box">
            <div class="model-box-header">
                <i class="mdui-icon material-icons">phonelink</i>
                <span class="model-label">快捷链接</span>
            </div>
            <div class="horizon"></div>
            <div class="model-box-content" id="link-box-content">
                <ul><a href="https://ipangbo.cn" target="_blank">
                    <li>
                        <i class="mdui-icon material-icons">web</i>
                        <div class="link-title">气势磅礴</div>
                    </li>
                </a>
                    <a href="https://web.ab-in.cn/web/index" target="_blank">
                        <li>
                            <i class="mdui-icon material-icons">supervisor_account</i>
                            <div class="link-title">刘思远同学</div>
                        </li>
                    </a>
                    <a href="http://123.57.27.150:8857/web-project-manager/" target="_blank">
                        <li>
                            <i class="mdui-icon material-icons">grade</i>
                            <div class="link-title">课设平台</div>
                        </li>
                    </a>
                    <a href="https://gitee.com/ipangbocn/web-course-project" target="_blank">
                        <li>
                            <i class="mdui-icon material-icons">settings_system_daydream</i>
                            <div class="link-title">开源仓库</div>
                        </li>
                    </a>
                    <a href="https://github.com/bwhyman/web-course" target="_blank">
                        <li>
                            <i class="mdui-icon material-icons">account_balance</i>
                            <div class="link-title">在线课程</div>
                        </li>
                    </a>
                    <a href="panel/" target="_blank">
                        <li>
                            <i class="mdui-icon material-icons">account_circle</i>
                            <div class="link-title">投稿系统</div>
                        </li>
                    </a>
                </ul>
            </div>

        </div>
    </div>
</div>

<%@ include file="include/footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>