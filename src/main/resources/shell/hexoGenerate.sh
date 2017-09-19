#!/bin/sh
echo "info: 现在开始更新Hexo工具！";
rm -rf /usr/local/nginx/html/hexo/zzshexo/source/
mkdir  /usr/local/nginx/html/hexo/zzshexo/source/_posts
cp  /root/mywebapp/articleMarkdown/      /usr/local/nginx/html/hexo/zzshexo/source/_posts
cd /usr/local/nginx/html/hexo/zzshexo
hexo  g
echo "info:update"

