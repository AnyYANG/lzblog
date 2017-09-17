##  遇到的坑
- ajax请求成功但是返回404
>  mvc 返回没有加注解 responseBody  默认返回页面， 加上注解解决问题

-  ajax请求返回success 参数接受不到
>  ajax dataType 设置为json  这个json指的是传回的值解析为json 并不是传过去的值为json  dataType去掉后解决问题。
