##  遇到的坑
- ajax请求成功但是返回404
>  mvc 返回没有加注解 responseBody  默认返回页面， 加上注解解决问题

-  ajax请求返回success 参数接受不到
>  ajax dataType 设置为json  这个json指的是传回的值解析为json 并不是传过去的值为json  dataType去掉后解决问题。


-  shell文件无法执行Cannot run program "/root/mywebapp/shell/hexoGenerate.sh": error=26, Text file busy
>  shell文件被其他进程所占用，此处是ftp给占用了，所以不能执行。需要先fuser 查看进程信息，然后 kill 进程的id即可
指定的file, file system 或者 sockets的进程信息。fuser命令是用来显示所有正在使用着