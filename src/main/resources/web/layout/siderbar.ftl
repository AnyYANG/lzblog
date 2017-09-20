<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${Session.user.imgsrc!'##'}" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>   ${Session.user.username!"欢迎使用"}   </p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">管理列表</li>
            <li class="treeview">
                <a href="#"><i class="fa fa-edit"></i> <span>文章管理</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/article/addpage" class="active">发表新的文章</a></li>
                    <li><a href="#">文章列表</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
