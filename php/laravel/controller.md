## 控制器（Controller）
> mvc 设计模式中的一个重要组成部分：C（Controller）控制器

Laravel的控制器能够将相关的请求处理逻辑组成一个单独的类。控制器被存放在 `app/Http/Controllers` 目录下。

### 快速入门（简单使用）
####创建控制器。
在`app/Http/Controllers` 目录下创建一个 `TestController` 控制器。   

这里创建控制器的方式有两个：   
1. 第一个是使用命令行的方式创建。（**强烈推荐**）  
	创建控制器的语法：`php artisan make:controller 控制器名称`   
2. 第二个是使用正常创建文件的方式。
```php
<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TestController extends Controller
{
    // 这里写一个show方法作为demo
    public function show($id)
    {
		return 'Hello World !' . $id;
	}
}
```
> 。控制器并不是 一定 要继承基础类。只是，你将无法使用一些便捷的功能，比如 `middleware`，`validate` 和 `dispatch` 方法。
#### 注册路由
> laravel框架的所有控制器默认是访问不了的，必须注册路由才可以访问。
```
Route::get('test/{id}', 'TestController@show');
```

#### 浏览器访问
注册完成后就已经可以通过浏览器去访问了。`http://127.0.0.1/test/110`。   
结果：    
```html
Hello World !110
```

### 中间件
之前我们说过可以在路由加中间件。然而，在控制器的**构造方法**中指定中间件会更为便捷。在控制器**构造方法**中使用 `middleware` 方法，你可以很容易地将中间件指定给控制器操作。你甚至可以约束中间件只对控制器类中的某个特定方法生效：
```php
class TestController extends Controller
{
    /**
     * 创建一个新的控制器实例。
     *
     * @return void
     */
    public function __construct()
    {
        // 使用 auth 中间件验证
        $this->middleware('auth');

        // 使用 log 中间件，但只对 index 方法有效
        $this->middleware('log')->only('index');

        $this->middleware('subscribed')->except('store');
    }
}
```
> 控制器的`中间件`会比路由器的中间件更加方便。一般使用控制器里面定义中间件。

### RESTful控制器（资源控制器）
> 什么是RESTful？   
> REST 描述了一个架构样式的互联系统（如 Web 应用程序）。REST 约束条件作为一个整体应用时，将生成一个简单、可扩展、有效、安全、可靠的架构。由于它简便、轻量级以及通过 HTTP 直接传输数据的特性，RESTful Web 服务成为基于 SOAP 服务的一个最有前途的替代方案。用于 web 服务和动态 Web 应用程序的多层架构可以实现可重用性、简单性、可扩展性和组件可响应性的清晰分离。开发人员可以轻松使用 Ajax 和 RESTful Web 服务一起创建丰富的界面。
> ---
> 简单来说就是一套设计风格。提供了一些设计原则和约束条件。它主要用于客户端和服务器交互类的软件。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。

#### 创建资源控制器
Laravel 资源路由可以将典型的「CURD」路由指定到一个控制器上。使用 Artisan 命令 `make:controller`，就能快速创建这样一个控制器：
```
php artisan make:controller ArticleController --resource
```
#### 注册路由
> laravel框架的所有控制器默认是访问不了的，必须注册路由才可以访问。
```
Route::resource('photos', 'ArticleController');
```

这个路由声明会创建多个路由来处理各种各样的资源操作。前面生成的控制器已经包含了这些操作的方法，还包括了 HTTP 动作和操作 URI 的注释。

> 资源控制器操作处理#

| 动作 | URI | 操作 | 路由名称 |
| ---- | --- | ---- | ---- |
| GET |	/photos	 | index | photos.index |
| GET |	/photos/create | create	| photos.create |
| POST | /photos | store	| photos.store |
| GET |	/photos/{photo} | show	| photos.show |
| GET |	/photos/{photo}/edit | edit | photos.edit |
| PUT/PATCH  | /photos/{photo} | update | photos.update |
| DELETE |	/photos/{photo} | destroy | photos.destroy |

