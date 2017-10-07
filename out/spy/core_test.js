// Compiled by ClojureScript 1.9.946 {}
goog.provide('spy.core_test');
goog.require('cljs.core');
goog.require('cljs.test');
goog.require('spy.core');
spy.core_test.stub_call_counts = (function spy$core_test$stub_call_counts(){
return cljs.test.test_var.call(null,spy.core_test.stub_call_counts.cljs$lang$var);
});
spy.core_test.stub_call_counts.cljs$lang$test = (function (){
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"call counts");

try{var f = spy.core.stub.call(null,(42));
try{var value__13526__auto___13802 = spy.core.not_called_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13802)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13802,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13802,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13795){var t__13568__auto___13803 = e13795;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13803,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null);

try{var value__13526__auto___13804 = spy.core.called_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13804)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called?","s/called?",-104422325,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13804,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called?","s/called?",-104422325,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13804,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13796){var t__13568__auto___13805 = e13796;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called?","s/called?",-104422325,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13805,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var value__13526__auto___13806 = spy.core.called_once_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13806)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13806,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13806,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13797){var t__13568__auto___13807 = e13797;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13807,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null);

try{var value__13526__auto___13808 = spy.core.called_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13808)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called?","s/called?",-104422325,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13808,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called?","s/called?",-104422325,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13808,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13798){var t__13568__auto___13809 = e13798;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called?","s/called?",-104422325,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13809,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var value__13526__auto___13810 = spy.core.called_twice_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13810)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-twice?","s/called-twice?",1056530168,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13810,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-twice?","s/called-twice?",1056530168,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13810,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13799){var t__13568__auto___13811 = e13799;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-twice?","s/called-twice?",1056530168,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13811,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null);

try{var value__13526__auto___13812 = spy.core.called_thrice_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13812)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-thrice?","s/called-thrice?",327551107,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13812,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-thrice?","s/called-thrice?",327551107,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13812,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13800){var t__13568__auto___13813 = e13800;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-thrice?","s/called-thrice?",327551107,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13813,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var values__13523__auto__ = cljs.core._conj.call(null,(function (){var x__8338__auto__ = f;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),(3));
var result__13524__auto__ = cljs.core.apply.call(null,spy.core.called_n_QMARK_,values__13523__auto__);
if(cljs.core.truth_(result__13524__auto__)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-n?","s/called-n?",1361433777,null),(3),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,spy.core.called_n_QMARK_,values__13523__auto__),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-n?","s/called-n?",1361433777,null),(3),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol("s","called-n?","s/called-n?",1361433777,null),values__13523__auto__);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

return result__13524__auto__;
}catch (e13801){var t__13568__auto__ = e13801;
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-n?","s/called-n?",1361433777,null),(3),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}});

spy.core_test.stub_call_counts.cljs$lang$var = new cljs.core.Var(function(){return spy.core_test.stub_call_counts;},new cljs.core.Symbol("spy.core-test","stub-call-counts","spy.core-test/stub-call-counts",993306582,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"stub-call-counts","stub-call-counts",-2071073024,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",26,1,5,5,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.stub_call_counts)?spy.core_test.stub_call_counts.cljs$lang$test:null)]));
spy.core_test.called_at_least = (function spy$core_test$called_at_least(){
return cljs.test.test_var.call(null,spy.core_test.called_at_least.cljs$lang$var);
});
spy.core_test.called_at_least.cljs$lang$test = (function (){
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"called at least once");

try{var f = spy.core.stub.call(null,(42));
try{var values__13523__auto___13820 = (function (){var x__8338__auto__ = spy.core.called_at_least_QMARK_.call(null,(1),f);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})();
var result__13524__auto___13821 = cljs.core.apply.call(null,cljs.core.false_QMARK_,values__13523__auto___13820);
if(cljs.core.truth_(result__13524__auto___13821)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(1),new cljs.core.Symbol(null,"f","f",43394975,null))),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,cljs.core.false_QMARK_,values__13523__auto___13820),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(1),new cljs.core.Symbol(null,"f","f",43394975,null))),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol(null,"false?","false?",-1522377573,null),values__13523__auto___13820);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13814){var t__13568__auto___13822 = e13814;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(1),new cljs.core.Symbol(null,"f","f",43394975,null))),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13822,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null);

try{var values__13523__auto___13823 = cljs.core._conj.call(null,(function (){var x__8338__auto__ = f;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),(1));
var result__13524__auto___13824 = cljs.core.apply.call(null,spy.core.called_at_least_QMARK_,values__13523__auto___13823);
if(cljs.core.truth_(result__13524__auto___13824)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(1),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,spy.core.called_at_least_QMARK_,values__13523__auto___13823),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(1),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),values__13523__auto___13823);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13815){var t__13568__auto___13825 = e13815;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(1),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13825,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var value__13526__auto___13826 = spy.core.called_at_least_once_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13826)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-once?","s/called-at-least-once?",1373078329,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13826,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-once?","s/called-at-least-once?",1373078329,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13826,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13816){var t__13568__auto___13827 = e13816;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-once?","s/called-at-least-once?",1373078329,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13827,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null);

try{var value__13526__auto___13828 = spy.core.called_at_least_twice_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13828)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-twice?","s/called-at-least-twice?",-1895666676,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13828,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-twice?","s/called-at-least-twice?",-1895666676,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13828,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13817){var t__13568__auto___13829 = e13817;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-twice?","s/called-at-least-twice?",-1895666676,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13829,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null);

try{var value__13526__auto___13830 = spy.core.called_at_least_thrice_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13830)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-thrice?","s/called-at-least-thrice?",423563671,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13830,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-thrice?","s/called-at-least-thrice?",423563671,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13830,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13818){var t__13568__auto___13831 = e13818;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least-thrice?","s/called-at-least-thrice?",423563671,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13831,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
cljs.core.doall.call(null,cljs.core.repeatedly.call(null,(42),f));

try{var values__13523__auto__ = cljs.core._conj.call(null,(function (){var x__8338__auto__ = f;
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),(42));
var result__13524__auto__ = cljs.core.apply.call(null,spy.core.called_at_least_QMARK_,values__13523__auto__);
if(cljs.core.truth_(result__13524__auto__)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(42),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,spy.core.called_at_least_QMARK_,values__13523__auto__),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(42),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),values__13523__auto__);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

return result__13524__auto__;
}catch (e13819){var t__13568__auto__ = e13819;
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-at-least?","s/called-at-least?",1398274119,null),(42),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}});

spy.core_test.called_at_least.cljs$lang$var = new cljs.core.Var(function(){return spy.core_test.called_at_least;},new cljs.core.Symbol("spy.core-test","called-at-least","spy.core-test/called-at-least",2132386763,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-at-least","called-at-least",-643630279,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",25,1,19,19,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_at_least)?spy.core_test.called_at_least.cljs$lang$test:null)]));
spy.core_test.reset_spy = (function spy$core_test$reset_spy(){
return cljs.test.test_var.call(null,spy.core_test.reset_spy.cljs$lang$var);
});
spy.core_test.reset_spy.cljs$lang$test = (function (){
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"resetting the call count for a spy");

try{var f = spy.core.stub.call(null,(1863));
cljs.core.doall.call(null,cljs.core.repeatedly.call(null,(3),f));

try{var value__13526__auto___13834 = spy.core.called_thrice_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto___13834)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-thrice?","s/called-thrice?",327551107,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13834,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-thrice?","s/called-thrice?",327551107,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13834,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13832){var t__13568__auto___13835 = e13832;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-thrice?","s/called-thrice?",327551107,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13835,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
spy.core.reset_calls_BANG_.call(null,f);

try{var value__13526__auto__ = spy.core.not_called_QMARK_.call(null,f);
if(cljs.core.truth_(value__13526__auto__)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

return value__13526__auto__;
}catch (e13833){var t__13568__auto__ = e13833;
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}});

spy.core_test.reset_spy.cljs$lang$var = new cljs.core.Var(function(){return spy.core_test.reset_spy;},new cljs.core.Symbol("spy.core-test","reset-spy","spy.core-test/reset-spy",-1905273635,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"reset-spy","reset-spy",681085999,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",19,1,37,37,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.reset_spy)?spy.core_test.reset_spy.cljs$lang$test:null)]));
spy.core_test.spy_call_counts = (function spy$core_test$spy_call_counts(){
return cljs.test.test_var.call(null,spy.core_test.spy_call_counts.cljs$lang$var);
});
spy.core_test.spy_call_counts.cljs$lang$test = (function (){
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"call counts");

try{var f_13842 = spy.core.spy.call(null,(function (x,y){
return (x + y);
}));
try{var value__13526__auto___13843 = spy.core.not_called_QMARK_.call(null,f_13842);
if(cljs.core.truth_(value__13526__auto___13843)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13843,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13843,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13836){var t__13568__auto___13844 = e13836;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13844,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var values__13523__auto___13845 = cljs.core._conj.call(null,(function (){var x__8338__auto__ = f_13842.call(null,(1),(2));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),(3));
var result__13524__auto___13846 = cljs.core.apply.call(null,cljs.core._EQ_,values__13523__auto___13845);
if(cljs.core.truth_(result__13524__auto___13846)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"=","=",-1501502141,null),(3),cljs.core.list(new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2))),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,cljs.core._EQ_,values__13523__auto___13845),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"=","=",-1501502141,null),(3),cljs.core.list(new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2))),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol(null,"=","=",-1501502141,null),values__13523__auto___13845);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13837){var t__13568__auto___13847 = e13837;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"=","=",-1501502141,null),(3),cljs.core.list(new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2))),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13847,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var value__13526__auto___13848 = spy.core.called_once_QMARK_.call(null,f_13842);
if(cljs.core.truth_(value__13526__auto___13848)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13848,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13848,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13838){var t__13568__auto___13849 = e13838;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"f","f",43394975,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13849,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"call counts when the spy is wrapped with partial");

try{var spy__$1 = spy.core.spy.call(null,(function (x,y){
return (x + y);
}));
var pf = cljs.core.partial.call(null,spy__$1,(5));
try{var value__13526__auto___13850 = spy.core.not_called_QMARK_.call(null,spy__$1);
if(cljs.core.truth_(value__13526__auto___13850)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"spy","spy",-1949716369,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13850,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"spy","spy",-1949716369,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto___13850,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13839){var t__13568__auto___13851 = e13839;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called?","s/not-called?",1275945793,null),new cljs.core.Symbol(null,"spy","spy",-1949716369,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13851,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var values__13523__auto___13852 = cljs.core._conj.call(null,(function (){var x__8338__auto__ = pf.call(null,(3));
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),(8));
var result__13524__auto___13853 = cljs.core.apply.call(null,cljs.core._EQ_,values__13523__auto___13852);
if(cljs.core.truth_(result__13524__auto___13853)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"=","=",-1501502141,null),(8),cljs.core.list(new cljs.core.Symbol(null,"pf","pf",-1398675700,null),(3))),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,cljs.core._EQ_,values__13523__auto___13852),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"=","=",-1501502141,null),(8),cljs.core.list(new cljs.core.Symbol(null,"pf","pf",-1398675700,null),(3))),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol(null,"=","=",-1501502141,null),values__13523__auto___13852);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13840){var t__13568__auto___13854 = e13840;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"=","=",-1501502141,null),(8),cljs.core.list(new cljs.core.Symbol(null,"pf","pf",-1398675700,null),(3))),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13854,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var value__13526__auto__ = spy.core.called_once_QMARK_.call(null,spy__$1);
if(cljs.core.truth_(value__13526__auto__)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"spy","spy",-1949716369,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"spy","spy",-1949716369,null)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

return value__13526__auto__;
}catch (e13841){var t__13568__auto__ = e13841;
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-once?","s/called-once?",-225408222,null),new cljs.core.Symbol(null,"spy","spy",-1949716369,null)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}});

spy.core_test.spy_call_counts.cljs$lang$var = new cljs.core.Var(function(){return spy.core_test.spy_call_counts;},new cljs.core.Symbol("spy.core-test","spy-call-counts","spy.core-test/spy-call-counts",384708478,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"spy-call-counts","spy-call-counts",-10922036,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",25,1,45,45,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.spy_call_counts)?spy.core_test.spy_call_counts.cljs$lang$test:null)]));
spy.core_test.called_with_test = (function spy$core_test$called_with_test(){
return cljs.test.test_var.call(null,spy.core_test.called_with_test.cljs$lang$var);
});
spy.core_test.called_with_test.cljs$lang$test = (function (){
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"called with");

try{var f = spy.core.spy.call(null,cljs.core._PLUS_);
f.call(null,(1),(2));

try{var values__13523__auto___13858 = (function (){var x__8338__auto__ = f;
return cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,(2)),(1)),x__8338__auto__);
})();
var result__13524__auto___13859 = cljs.core.apply.call(null,spy.core.called_with_QMARK_,values__13523__auto___13858);
if(cljs.core.truth_(result__13524__auto___13859)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,spy.core.called_with_QMARK_,values__13523__auto___13858),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),values__13523__auto___13858);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13855){var t__13568__auto___13860 = e13855;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13860,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
f.call(null,(1),(2),(3));

try{var values__13523__auto___13861 = (function (){var x__8338__auto__ = f;
return cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,(3)),(2)),(1)),x__8338__auto__);
})();
var result__13524__auto___13862 = cljs.core.apply.call(null,spy.core.called_with_QMARK_,values__13523__auto___13861);
if(cljs.core.truth_(result__13524__auto___13862)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2),(3)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,spy.core.called_with_QMARK_,values__13523__auto___13861),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2),(3)),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),values__13523__auto___13861);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13856){var t__13568__auto___13863 = e13856;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with?","s/called-with?",-234596628,null),new cljs.core.Symbol(null,"f","f",43394975,null),(1),(2),(3)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13863,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var value__13526__auto__ = spy.core.not_called_with_QMARK_.call(null,f,(7),(8));
if(cljs.core.truth_(value__13526__auto__)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called-with?","s/not-called-with?",-814548898,null),new cljs.core.Symbol(null,"f","f",43394975,null),(7),(8)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called-with?","s/not-called-with?",-814548898,null),new cljs.core.Symbol(null,"f","f",43394975,null),(7),(8)),new cljs.core.Keyword(null,"actual","actual",107306363),value__13526__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

return value__13526__auto__;
}catch (e13857){var t__13568__auto__ = e13857;
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","not-called-with?","s/not-called-with?",-814548898,null),new cljs.core.Symbol(null,"f","f",43394975,null),(7),(8)),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}});

spy.core_test.called_with_test.cljs$lang$var = new cljs.core.Var(function(){return spy.core_test.called_with_test;},new cljs.core.Symbol("spy.core-test","called-with-test","spy.core-test/called-with-test",910256288,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-with-test","called-with-test",-572645038,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",26,1,59,59,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_with_test)?spy.core_test.called_with_test.cljs$lang$test:null)]));
spy.core_test.called_with_exactly = (function spy$core_test$called_with_exactly(){
return cljs.test.test_var.call(null,spy.core_test.called_with_exactly.cljs$lang$var);
});
spy.core_test.called_with_exactly.cljs$lang$test = (function (){
var f = spy.core.spy.call(null,cljs.core.str);
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"called with exactly");

try{f.call(null,"hello world!");

try{var values__13523__auto___13867 = (function (){var x__8338__auto__ = f;
return cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,"hello world!"),x__8338__auto__);
})();
var result__13524__auto___13868 = cljs.core.apply.call(null,spy.core.called_with_exactly_QMARK_,values__13523__auto___13867);
if(cljs.core.truth_(result__13524__auto___13868)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"hello world!"),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,spy.core.called_with_exactly_QMARK_,values__13523__auto___13867),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"hello world!"),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),values__13523__auto___13867);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13864){var t__13568__auto___13869 = e13864;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"hello world!"),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13869,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}
cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.conj,"returns false if there were other calls");

try{f.call(null,"foo bar");

try{var values__13523__auto___13870 = (function (){var x__8338__auto__ = spy.core.called_with_exactly_QMARK_.call(null,f,"foo bar");
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})();
var result__13524__auto___13871 = cljs.core.apply.call(null,cljs.core.false_QMARK_,values__13523__auto___13870);
if(cljs.core.truth_(result__13524__auto___13871)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"foo bar")),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,cljs.core.false_QMARK_,values__13523__auto___13870),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"foo bar")),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol(null,"false?","false?",-1522377573,null),values__13523__auto___13870);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

}catch (e13865){var t__13568__auto___13872 = e13865;
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"foo bar")),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto___13872,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}
try{var values__13523__auto__ = (function (){var x__8338__auto__ = spy.core.called_with_exactly_QMARK_.call(null,f,"hello","world","!");
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})();
var result__13524__auto__ = cljs.core.apply.call(null,cljs.core.false_QMARK_,values__13523__auto__);
if(cljs.core.truth_(result__13524__auto__)){
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"pass","pass",1574159993),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"hello","world","!")),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core.cons.call(null,cljs.core.false_QMARK_,values__13523__auto__),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
} else {
cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"fail","fail",1706214930),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"hello","world","!")),new cljs.core.Keyword(null,"actual","actual",107306363),cljs.core._conj.call(null,(function (){var x__8338__auto__ = cljs.core.cons.call(null,new cljs.core.Symbol(null,"false?","false?",-1522377573,null),values__13523__auto__);
return cljs.core._conj.call(null,cljs.core.List.EMPTY,x__8338__auto__);
})(),new cljs.core.Symbol(null,"not","not",1044554643,null)),new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}

return result__13524__auto__;
}catch (e13866){var t__13568__auto__ = e13866;
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"expected","expected",1583670997),cljs.core.list(new cljs.core.Symbol(null,"false?","false?",-1522377573,null),cljs.core.list(new cljs.core.Symbol("s","called-with-exactly?","s/called-with-exactly?",321396047,null),new cljs.core.Symbol(null,"f","f",43394975,null),"hello","world","!")),new cljs.core.Keyword(null,"actual","actual",107306363),t__13568__auto__,new cljs.core.Keyword(null,"message","message",-406056002),null], null));
}}finally {cljs.test.update_current_env_BANG_.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"testing-contexts","testing-contexts",-1485646523)], null),cljs.core.rest);
}});

spy.core_test.called_with_exactly.cljs$lang$var = new cljs.core.Var(function(){return spy.core_test.called_with_exactly;},new cljs.core.Symbol("spy.core-test","called-with-exactly","spy.core-test/called-with-exactly",-2122959577,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-with-exactly","called-with-exactly",654216657,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",29,1,68,68,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_with_exactly)?spy.core_test.called_with_exactly.cljs$lang$test:null)]));
