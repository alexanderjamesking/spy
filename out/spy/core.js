// Compiled by ClojureScript 1.9.946 {}
goog.provide('spy.core');
goog.require('cljs.core');
spy.core.no_calls = cljs.core.PersistentVector.EMPTY;
spy.core.spy = (function spy$core$spy(f){
var calls = cljs.core.atom.call(null,spy.core.no_calls);
return cljs.core.with_meta.call(null,((function (calls){
return (function() { 
var G__13779__delegate = function (args){
cljs.core.swap_BANG_.call(null,calls,cljs.core.conj,args);

return cljs.core.apply.call(null,f,args);
};
var G__13779 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__13780__i = 0, G__13780__a = new Array(arguments.length -  0);
while (G__13780__i < G__13780__a.length) {G__13780__a[G__13780__i] = arguments[G__13780__i + 0]; ++G__13780__i;}
  args = new cljs.core.IndexedSeq(G__13780__a,0,null);
} 
return G__13779__delegate.call(this,args);};
G__13779.cljs$lang$maxFixedArity = 0;
G__13779.cljs$lang$applyTo = (function (arglist__13781){
var args = cljs.core.seq(arglist__13781);
return G__13779__delegate(args);
});
G__13779.cljs$core$IFn$_invoke$arity$variadic = G__13779__delegate;
return G__13779;
})()
;})(calls))
,new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"calls","calls",-433802344),calls], null));
});
spy.core.reset_calls_BANG_ = (function spy$core$reset_calls_BANG_(f){
return cljs.core.reset_BANG_.call(null,new cljs.core.Keyword(null,"calls","calls",-433802344).cljs$core$IFn$_invoke$arity$1(cljs.core.meta.call(null,f)),spy.core.no_calls);
});
spy.core.stub = (function spy$core$stub(value){
return spy.core.spy.call(null,cljs.core.constantly.call(null,value));
});
spy.core.calls = (function spy$core$calls(f){
return cljs.core.deref.call(null,new cljs.core.Keyword(null,"calls","calls",-433802344).cljs$core$IFn$_invoke$arity$1(cljs.core.meta.call(null,f)));
});
spy.core.call_count = (function spy$core$call_count(f){
return cljs.core.count.call(null,spy.core.calls.call(null,f));
});
spy.core.called_n_QMARK_ = (function spy$core$called_n_QMARK_(n,f){
return cljs.core._EQ_.call(null,n,spy.core.call_count.call(null,f));
});
spy.core.not_called_QMARK_ = cljs.core.partial.call(null,spy.core.called_n_QMARK_,(0));
spy.core.called_once_QMARK_ = cljs.core.partial.call(null,spy.core.called_n_QMARK_,(1));
spy.core.called_twice_QMARK_ = cljs.core.partial.call(null,spy.core.called_n_QMARK_,(2));
spy.core.called_thrice_QMARK_ = cljs.core.partial.call(null,spy.core.called_n_QMARK_,(3));
spy.core.called_with_QMARK_ = (function spy$core$called_with_QMARK_(var_args){
var args__8654__auto__ = [];
var len__8647__auto___13785 = arguments.length;
var i__8648__auto___13786 = (0);
while(true){
if((i__8648__auto___13786 < len__8647__auto___13785)){
args__8654__auto__.push((arguments[i__8648__auto___13786]));

var G__13787 = (i__8648__auto___13786 + (1));
i__8648__auto___13786 = G__13787;
continue;
} else {
}
break;
}

var argseq__8655__auto__ = ((((1) < args__8654__auto__.length))?(new cljs.core.IndexedSeq(args__8654__auto__.slice((1)),(0),null)):null);
return spy.core.called_with_QMARK_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__8655__auto__);
});

spy.core.called_with_QMARK_.cljs$core$IFn$_invoke$arity$variadic = (function (f,args){
return cljs.core.some.call(null,(function (p1__13782_SHARP_){
return cljs.core._EQ_.call(null,args,p1__13782_SHARP_);
}),spy.core.calls.call(null,f));
});

spy.core.called_with_QMARK_.cljs$lang$maxFixedArity = (1);

spy.core.called_with_QMARK_.cljs$lang$applyTo = (function (seq13783){
var G__13784 = cljs.core.first.call(null,seq13783);
var seq13783__$1 = cljs.core.next.call(null,seq13783);
return spy.core.called_with_QMARK_.cljs$core$IFn$_invoke$arity$variadic(G__13784,seq13783__$1);
});

spy.core.not_called_with_QMARK_ = cljs.core.complement.call(null,spy.core.called_with_QMARK_);
spy.core.called_with_exactly_QMARK_ = (function spy$core$called_with_exactly_QMARK_(var_args){
var args__8654__auto__ = [];
var len__8647__auto___13790 = arguments.length;
var i__8648__auto___13791 = (0);
while(true){
if((i__8648__auto___13791 < len__8647__auto___13790)){
args__8654__auto__.push((arguments[i__8648__auto___13791]));

var G__13792 = (i__8648__auto___13791 + (1));
i__8648__auto___13791 = G__13792;
continue;
} else {
}
break;
}

var argseq__8655__auto__ = ((((1) < args__8654__auto__.length))?(new cljs.core.IndexedSeq(args__8654__auto__.slice((1)),(0),null)):null);
return spy.core.called_with_exactly_QMARK_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__8655__auto__);
});

spy.core.called_with_exactly_QMARK_.cljs$core$IFn$_invoke$arity$variadic = (function (f,args){
return cljs.core._EQ_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [args], null),spy.core.calls.call(null,f));
});

spy.core.called_with_exactly_QMARK_.cljs$lang$maxFixedArity = (1);

spy.core.called_with_exactly_QMARK_.cljs$lang$applyTo = (function (seq13788){
var G__13789 = cljs.core.first.call(null,seq13788);
var seq13788__$1 = cljs.core.next.call(null,seq13788);
return spy.core.called_with_exactly_QMARK_.cljs$core$IFn$_invoke$arity$variadic(G__13789,seq13788__$1);
});

spy.core.called_at_least_n_QMARK_ = (function spy$core$called_at_least_n_QMARK_(n,f){
return (spy.core.call_count.call(null,f) >= n);
});
spy.core.called_at_least_QMARK_ = (function spy$core$called_at_least_QMARK_(f,n){
return spy.core.called_at_least_n_QMARK_.call(null,f,n);
});
spy.core.called_QMARK_ = cljs.core.partial.call(null,spy.core.called_at_least_QMARK_,(1));
spy.core.called_at_least_once_QMARK_ = cljs.core.partial.call(null,spy.core.called_at_least_QMARK_,(1));
spy.core.called_at_least_twice_QMARK_ = cljs.core.partial.call(null,spy.core.called_at_least_QMARK_,(2));
spy.core.called_at_least_thrice_QMARK_ = cljs.core.partial.call(null,spy.core.called_at_least_QMARK_,(3));
