<%@ page pageEncoding="utf-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<style>
.active {
	background-color: rgba(247, 228, 18, 0.3);
}
</style>
<div class="vertical-menu">
	<div class="logo">
		<div class="img"></div>
	</div>
	<a class="item main ${activeMenu=='main' ? 'active' : ''}" href="/"></a>
	<a class="item courses ${activeMenu=='courses' ? 'active' : ''}" href="/blog"></a>
	<a class="item webinars ${activeMenu=='webinars' ? 'active' : ''}" href="/blog"></a>
	<a class="item blog ${activeMenu=='blog' ? 'active' : ''}" href="/blog"></a>
	<a class="item career ${activeMenu=='career' ? 'active' : ''}" href="/blog"></a>

</div>
