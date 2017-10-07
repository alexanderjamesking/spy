// Compiled by ClojureScript 1.9.946 {}
goog.provide('spy.runner');
goog.require('cljs.core');
goog.require('doo.runner');
goog.require('spy.core_test');
doo.runner.set_entry_point_BANG_.call(null,(cljs.core.truth_(doo.runner.karma_QMARK_.call(null))?(function (tc__13896__auto__){
jx.reporter.karma.start.call(null,tc__13896__auto__,6);

return cljs.test.run_block.call(null,(function (){var env13904 = cljs.test.empty_env.call(null,new cljs.core.Keyword("jx.reporter.karma","karma","jx.reporter.karma/karma",404831826));
var summary13905 = cljs.core.volatile_BANG_.call(null,new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"summary","summary",380847952),new cljs.core.Keyword(null,"fail","fail",1706214930),(0),new cljs.core.Keyword(null,"error","error",-978969032),(0),new cljs.core.Keyword(null,"pass","pass",1574159993),(0),new cljs.core.Keyword(null,"test","test",577538877),(0)], null));
return cljs.core.concat.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env13904,summary13905){
return (function (){
cljs.test.set_env_BANG_.call(null,env13904);

cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"begin-test-ns","begin-test-ns",-1701237033)], null));

return cljs.test.block.call(null,(function (){var env__13634__auto__ = cljs.test.get_current_env.call(null);
return cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env__13634__auto__,env13904,summary13905){
return (function (){
if((env__13634__auto__ == null)){
cljs.test.set_env_BANG_.call(null,cljs.test.empty_env.call(null));
} else {
}


return null;
});})(env__13634__auto__,env13904,summary13905))
], null),cljs.test.test_vars_block.call(null,new cljs.core.PersistentVector(null, 6, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Var(function(){return spy.core_test.stub_call_counts;},new cljs.core.Symbol("spy.core-test","stub-call-counts","spy.core-test/stub-call-counts",993306582,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"stub-call-counts","stub-call-counts",-2071073024,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",26,1,5,5,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.stub_call_counts)?spy.core_test.stub_call_counts.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.called_at_least;},new cljs.core.Symbol("spy.core-test","called-at-least","spy.core-test/called-at-least",2132386763,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-at-least","called-at-least",-643630279,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",25,1,19,19,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_at_least)?spy.core_test.called_at_least.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.reset_spy;},new cljs.core.Symbol("spy.core-test","reset-spy","spy.core-test/reset-spy",-1905273635,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"reset-spy","reset-spy",681085999,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",19,1,37,37,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.reset_spy)?spy.core_test.reset_spy.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.spy_call_counts;},new cljs.core.Symbol("spy.core-test","spy-call-counts","spy.core-test/spy-call-counts",384708478,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"spy-call-counts","spy-call-counts",-10922036,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",25,1,45,45,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.spy_call_counts)?spy.core_test.spy_call_counts.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.called_with_test;},new cljs.core.Symbol("spy.core-test","called-with-test","spy.core-test/called-with-test",910256288,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-with-test","called-with-test",-572645038,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",26,1,59,59,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_with_test)?spy.core_test.called_with_test.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.called_with_exactly;},new cljs.core.Symbol("spy.core-test","called-with-exactly","spy.core-test/called-with-exactly",-2122959577,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-with-exactly","called-with-exactly",654216657,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",29,1,68,68,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_with_exactly)?spy.core_test.called_with_exactly.cljs$lang$test:null)]))], null)),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env__13634__auto__,env13904,summary13905){
return (function (){
if((env__13634__auto__ == null)){
return cljs.test.clear_env_BANG_.call(null);
} else {
return null;
}
});})(env__13634__auto__,env13904,summary13905))
], null));
})());
});})(env13904,summary13905))
,((function (env13904,summary13905){
return (function (){
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"end-test-ns","end-test-ns",1620675645)], null));
});})(env13904,summary13905))
], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env13904,summary13905){
return (function (){
return cljs.core._vreset_BANG_.call(null,summary13905,cljs.core.partial.call(null,cljs.core.merge_with,cljs.core._PLUS_).call(null,cljs.core._deref.call(null,summary13905),new cljs.core.Keyword(null,"report-counters","report-counters",-1702609242).cljs$core$IFn$_invoke$arity$1(cljs.test.get_and_clear_env_BANG_.call(null))));
});})(env13904,summary13905))
], null)),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env13904,summary13905){
return (function (){
cljs.test.set_env_BANG_.call(null,env13904);

cljs.test.do_report.call(null,cljs.core.deref.call(null,summary13905));

cljs.test.report.call(null,cljs.core.assoc.call(null,cljs.core.deref.call(null,summary13905),new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"end-run-tests","end-run-tests",267300563)));

return cljs.test.clear_env_BANG_.call(null);
});})(env13904,summary13905))
], null));
})());
}):(function (){
return cljs.test.run_block.call(null,(function (){var env13906 = cljs.test.empty_env.call(null);
var summary13907 = cljs.core.volatile_BANG_.call(null,new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"summary","summary",380847952),new cljs.core.Keyword(null,"fail","fail",1706214930),(0),new cljs.core.Keyword(null,"error","error",-978969032),(0),new cljs.core.Keyword(null,"pass","pass",1574159993),(0),new cljs.core.Keyword(null,"test","test",577538877),(0)], null));
return cljs.core.concat.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env13906,summary13907){
return (function (){
cljs.test.set_env_BANG_.call(null,env13906);

cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"begin-test-ns","begin-test-ns",-1701237033)], null));

return cljs.test.block.call(null,(function (){var env__13634__auto__ = cljs.test.get_current_env.call(null);
return cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env__13634__auto__,env13906,summary13907){
return (function (){
if((env__13634__auto__ == null)){
cljs.test.set_env_BANG_.call(null,cljs.test.empty_env.call(null));
} else {
}


return null;
});})(env__13634__auto__,env13906,summary13907))
], null),cljs.test.test_vars_block.call(null,new cljs.core.PersistentVector(null, 6, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Var(function(){return spy.core_test.stub_call_counts;},new cljs.core.Symbol("spy.core-test","stub-call-counts","spy.core-test/stub-call-counts",993306582,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"stub-call-counts","stub-call-counts",-2071073024,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",26,1,5,5,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.stub_call_counts)?spy.core_test.stub_call_counts.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.called_at_least;},new cljs.core.Symbol("spy.core-test","called-at-least","spy.core-test/called-at-least",2132386763,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-at-least","called-at-least",-643630279,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",25,1,19,19,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_at_least)?spy.core_test.called_at_least.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.reset_spy;},new cljs.core.Symbol("spy.core-test","reset-spy","spy.core-test/reset-spy",-1905273635,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"reset-spy","reset-spy",681085999,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",19,1,37,37,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.reset_spy)?spy.core_test.reset_spy.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.spy_call_counts;},new cljs.core.Symbol("spy.core-test","spy-call-counts","spy.core-test/spy-call-counts",384708478,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"spy-call-counts","spy-call-counts",-10922036,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",25,1,45,45,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.spy_call_counts)?spy.core_test.spy_call_counts.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.called_with_test;},new cljs.core.Symbol("spy.core-test","called-with-test","spy.core-test/called-with-test",910256288,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-with-test","called-with-test",-572645038,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",26,1,59,59,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_with_test)?spy.core_test.called_with_test.cljs$lang$test:null)])),new cljs.core.Var(function(){return spy.core_test.called_with_exactly;},new cljs.core.Symbol("spy.core-test","called-with-exactly","spy.core-test/called-with-exactly",-2122959577,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Symbol(null,"called-with-exactly","called-with-exactly",654216657,null),"/Users/alex/workspace/clj-spy/test/spy/core_test.cljc",29,1,68,68,cljs.core.List.EMPTY,null,(cljs.core.truth_(spy.core_test.called_with_exactly)?spy.core_test.called_with_exactly.cljs$lang$test:null)]))], null)),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env__13634__auto__,env13906,summary13907){
return (function (){
if((env__13634__auto__ == null)){
return cljs.test.clear_env_BANG_.call(null);
} else {
return null;
}
});})(env__13634__auto__,env13906,summary13907))
], null));
})());
});})(env13906,summary13907))
,((function (env13906,summary13907){
return (function (){
return cljs.test.do_report.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Symbol(null,"spy.core-test","spy.core-test",-1586709116,null),new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"end-test-ns","end-test-ns",1620675645)], null));
});})(env13906,summary13907))
], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env13906,summary13907){
return (function (){
return cljs.core._vreset_BANG_.call(null,summary13907,cljs.core.partial.call(null,cljs.core.merge_with,cljs.core._PLUS_).call(null,cljs.core._deref.call(null,summary13907),new cljs.core.Keyword(null,"report-counters","report-counters",-1702609242).cljs$core$IFn$_invoke$arity$1(cljs.test.get_and_clear_env_BANG_.call(null))));
});})(env13906,summary13907))
], null)),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [((function (env13906,summary13907){
return (function (){
cljs.test.set_env_BANG_.call(null,env13906);

cljs.test.do_report.call(null,cljs.core.deref.call(null,summary13907));

cljs.test.report.call(null,cljs.core.assoc.call(null,cljs.core.deref.call(null,summary13907),new cljs.core.Keyword(null,"type","type",1174270348),new cljs.core.Keyword(null,"end-run-tests","end-run-tests",267300563)));

return cljs.test.clear_env_BANG_.call(null);
});})(env13906,summary13907))
], null));
})());
})));
