<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML5手机端登录界面特效 - A5源码</title>

    <link rel="stylesheet" type="text/css" href="css/default.css">

    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>

<div class='login'>
    <div class='login_title'>
        <span>账号登录</span>
    </div>
    <div class='login_fields'>
        <div class='login_fields__user'>
            <div class='icon'>
                <img src='img/user_icon_copy.png'>
            </div>
            <input placeholder='用户名' type='text'>
            <div class='validation'>
                <img src='img/tick.png'>
            </div>
            </input>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='img/lock_icon_copy.png'>
            </div>
            <input placeholder='密码' type='password'>
            <div class='validation'>
                <img src='img/tick.png'>
            </div>
        </div>
        <div class='login_fields__submit'>
            <input type='submit' value='登录'>
            <div class='forgot'>
                <a href='#'>忘记密码?</a>
            </div>
        </div>
    </div>
    <div class='success'>
        <h2>认证成功</h2>
        <p>欢迎回来</p>
    </div>
    <div class='disclaimer'>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce semper laoreet placerat. Nullam semper auctor justo, rutrum posuere odio vulputate nec.</p>
    </div>
</div>
<div class='authent'>

    <p>认证中...</p>
</div>

<script type="text/javascript" src="js/stopExecutionOnTimeout.js?t=1"></script>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script>
    $('input[type="submit"]').click(function () {
        $('.login').addClass('test');
        setTimeout(function () {
            $('.login').addClass('testtwo');
        }, 300);
        setTimeout(function () {
            $('.authent').show().animate({ right: -320 }, {
                easing: 'easeOutQuint',
                duration: 600,
                queue: false
            });
            $('.authent').animate({ opacity: 1 }, {
                duration: 200,
                queue: false
            }).addClass('visible');
        }, 500);
        setTimeout(function () {
            $('.authent').show().animate({ right: 90 }, {
                easing: 'easeOutQuint',
                duration: 600,
                queue: false
            });
            $('.authent').animate({ opacity: 0 }, {
                duration: 200,
                queue: false
            }).addClass('visible');
            $('.login').removeClass('testtwo');
        }, 2500);
        setTimeout(function () {
            $('.login').removeClass('test');
            $('.login div').fadeOut(123);
        }, 2800);
        setTimeout(function () {
            $('.success').fadeIn();
        }, 3200);
    });
    $('input[type="text"],input[type="password"]').focus(function () {
        $(this).prev().animate({ 'opacity': '1' }, 200);
    });
    $('input[type="text"],input[type="password"]').blur(function () {
        $(this).prev().animate({ 'opacity': '.5' }, 200);
    });
    $('input[type="text"],input[type="password"]').keyup(function () {
        if (!$(this).val() == '') {
            $(this).next().animate({
                'opacity': '1',
                'right': '30'
            }, 200);
        } else {
            $(this).next().animate({
                'opacity': '0',
                'right': '20'
            }, 200);
        }
    });
    var open = 0;
    $('.tab').click(function () {
        $(this).fadeOut(200, function () {
            $(this).parent().animate({ 'left': '0' });
        });
    });
</script>

<div style="text-align:center;">
    <p>来源:<a href="http://liuyang.website/" target="_blank">刘洋在线</a></p>
</div>

</body>
</html>
