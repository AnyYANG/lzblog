#!/bin/sh
echo "info: startHexo";
rm -rf /usr/local/nginx/html/hexo/zzshexo/source/_posts
cp -r  /root/mywebapp/articleMarkdown/article/      /usr/local/nginx/html/hexo/zzshexo/source/_posts
cd /usr/local/nginx/html/hexo/zzshexo
hexo  g
echo "info:update"
