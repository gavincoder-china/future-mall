## Middleware 中间件
> Laravel 中间件提供了一种方便的机制来过滤进入应用的 HTTP 请求。

### 创建中间件
```
php  artisan make:middleware 类名
```
> 当然你可以手动创建一个。在 `app/Http/Middleware` 目录下创建一个类。
```php
<?php
// 例如：
namespace App\Http\Middleware;
use Closure;
class Test
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
        return $next($request);
    }
}
```

### 前置中间件 / 后置中间件
中间件运行在请求之前或之后取决于中间件本身。例如，以下中间件会在请求被应用处理 之前 执行一些任务
```php
<?php
namespace App\Http\Middleware;
use Closure;

class BeforeMiddleware
{
    public function handle($request, Closure $next)
    {
        // 执行动作

        return $next($request);
    }
}
```

然而，这个中间件会在请求被应用处理 之后 执行它的任务：
```php
<?php
namespace App\Http\Middleware;
use Closure;

class AfterMiddleware
{
    public function handle($request, Closure $next)
    {
        $response = $next($request);

        // 执行动作

        return $response;
    }
}
```

## 注册中间件（Kernel.php）
### 全局注册（middleware ）
如果你希望访问你应用的每个 HTTP 请求都经过某个中间件，只需将该中间件类列入 `app/Http/Kernel.php` 类里的 `$middleware` 属性。

### 路由注册（routeMiddleware）
如果你想为特殊的路由指定中间件，首先应该在 `app/Http/Kernel.php` 文件内为该中间件指定一个 键值。默认情况下 Kernel 类的 `$routeMiddleware` 属性已经包含了 Laravel 内置的中间件条目。加入自定义的中间件，只需把它附加到此列表并指定你定义的键值即可。例如：
```php
<?php
/**
 * The application's route middleware.
 *
 * These middleware may be assigned to groups or used individually.
 *
 * @var array
 */
protected $routeMiddleware = [
    'auth' => \Illuminate\Auth\Middleware\Authenticate::class,
    'auth.basic' => \Illuminate\Auth\Middleware\AuthenticateWithBasicAuth::class,
    'bindings' => \Illuminate\Routing\Middleware\SubstituteBindings::class,
    'can' => \Illuminate\Auth\Middleware\Authorize::class,
    'guest' => \App\Http\Middleware\RedirectIfAuthenticated::class,
    'throttle' => \Illuminate\Routing\Middleware\ThrottleRequests::class,
    // 按照数组的键值对形式添加路由中间件。
];
```
一旦在 HTTP kernel 文件内定义了中间件，即可使用 middleware 方法将中间件分配给路由：
```php
Route::get('admin/profile', function () {
    //
})->middleware('auth');
```
为路由指定多个中间件：
```php
Route::get('/', function () {
    //
})->middleware('first', 'second');
```
也可使用完整类名指定中间件：
```php
use App\Http\Middleware\CheckAge;

Route::get('admin/profile', function () {
    //
})->middleware(CheckAge::class);
```

### 中间件组（middlewareGroups）
有时您可能想要将多个中间件分组到同一个键值下，从而使它们更方便地分配给路由，你可以使用 HTTP kernel 的 `$middlewareGroups` 属性来实现。
```php
<?php
/**
 * 应用的路由中间件组
 *
 * @var array
 */
protected $middlewareGroups = [
    'web' => [
        \App\Http\Middleware\EncryptCookies::class,
        \Illuminate\Cookie\Middleware\AddQueuedCookiesToResponse::class,
        \Illuminate\Session\Middleware\StartSession::class,
        \Illuminate\View\Middleware\ShareErrorsFromSession::class,
        \App\Http\Middleware\VerifyCsrfToken::class,
        \Illuminate\Routing\Middleware\SubstituteBindings::class,
    ],

    'api' => [
        'throttle:60,1',
        'auth:api',
    ],
];
```
中间件组可以像单个中间件一样使用相同的语法指定给路由和控制器。重申，路由组仅仅是为了使一次将多个中间件指定给某个路由的实现变得更加方便。
```php
<?php
Route::get('/', function () {
    //
})->middleware('web');

Route::group(['middleware' => ['web']], function () {
    //
});
```
