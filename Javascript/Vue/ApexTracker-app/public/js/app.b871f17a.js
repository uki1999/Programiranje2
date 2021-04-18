(function(e){function t(t){for(var r,s,i=t[0],l=t[1],c=t[2],p=0,f=[];p<i.length;p++)s=i[p],Object.prototype.hasOwnProperty.call(n,s)&&n[s]&&f.push(n[s][0]),n[s]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(e[r]=l[r]);u&&u(t);while(f.length)f.shift()();return o.push.apply(o,c||[]),a()}function a(){for(var e,t=0;t<o.length;t++){for(var a=o[t],r=!0,i=1;i<a.length;i++){var l=a[i];0!==n[l]&&(r=!1)}r&&(o.splice(t--,1),e=s(s.s=a[0]))}return e}var r={},n={app:0},o=[];function s(t){if(r[t])return r[t].exports;var a=r[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,s),a.l=!0,a.exports}s.m=e,s.c=r,s.d=function(e,t,a){s.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},s.t=function(e,t){if(1&t&&(e=s(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(s.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)s.d(a,r,function(t){return e[t]}.bind(null,r));return a},s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,"a",t),t},s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},s.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var c=0;c<i.length;c++)t(i[c]);var u=l;o.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"034f":function(e,t,a){"use strict";a("85ec")},"0e48":function(e,t,a){"use strict";a("dc7b")},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var r=a("2b0e"),n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"containter"}},[a("Header"),a("router-view")],1)},o=[],s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("header",[a("img",{attrs:{src:e.image}})])},i=[],l={name:"Header",data:function(){return{image:a("cf05")}}},c=l,u=(a("9e7b"),a("2877")),p=Object(u["a"])(c,s,i,!1,null,"51cd0cf6",null),f=p.exports,m={name:"App",components:{Header:f}},d=m,g=(a("034f"),Object(u["a"])(d,n,o,!1,null,null,null)),v=g.exports,_=a("8c4f"),b=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("section",{staticClass:"search"},[a("h1",[e._v("Track Player Stats")]),a("form",{on:{submit:function(t){return t.preventDefault(),e.onSubmit(t)}}},[a("div",{staticClass:"form-group"},[a("label",{attrs:{for:"platform"}},[e._v("Platform")]),a("select",{directives:[{name:"model",rawName:"v-model",value:e.platform,expression:"platform"}],attrs:{name:"platform",id:"platform"},on:{change:function(t){var a=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.platform=t.target.multiple?a:a[0]}}},[a("option",{attrs:{value:"psn"}},[e._v("Playstation")]),a("option",{attrs:{value:"xbl"}},[e._v("Xbox")]),a("option",{attrs:{value:"origin"}},[e._v("Origin")])])]),a("div",{staticClass:"form-group"},[a("label",{attrs:{for:"gamertag"}},[e._v("Gamertag")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.gamertag,expression:"gamertag"}],attrs:{type:"text",name:"text",id:"gamertag",placeholder:"Place your ID (PSN, Origin, Xbox)?"},domProps:{value:e.gamertag},on:{input:function(t){t.target.composing||(e.gamertag=t.target.value)}}})]),e._m(0)])])},h=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"form-group"},[a("input",{staticClass:"btn",attrs:{type:"submit",value:"Submit"}})])}],y=(a("99af"),{name:"Search",data:function(){return{platform:"psn",gamertag:""}},beforeCreate:function(){document.body.className="body-bg-image"},methods:{onSubmit:function(){this.gamertag?this.$router.push("/profile/".concat(this.platform,"/").concat(this.gamertag)):this.$toasted.show("Enter gamertag!",{duration:3e3,icon:"exclamation-circle"})}}}),D=y,x=Object(u["a"])(D,b,h,!1,null,"02b4ece3",null),w=x.exports,O=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("section",[e.loading?a("div",[a("h3",[e._v("Loading...")])]):e._e(),e.error?a("div",[a("h1",[e._v(e._s(e.error))]),a("router-link",{attrs:{to:"/"}},[e._v("Go Back")])],1):e._e(),e.profileData?a("div",{staticClass:"container"},[a("h1",{staticClass:"gamertag"},[a("img",{staticClass:"platform-avatar",attrs:{src:e.profileData.platformInfo.avatarUrl}}),e._v(" "+e._s(e.profileData.platformInfo.platformUserId)+" ")]),a("div",{staticClass:"grid"},[a("div",[a("img",{attrs:{src:e.profileData.segments[1].metadata.imageUrl}})]),a("div",[a("ul",[a("li",[a("h4",[e._v("Selected Legend")]),a("p",[e._v(e._s(e.profileData.metadata.activeLegendName))])]),e.profileData.segments[0].stats.season2Wins?a("li",[a("h4",[e._v("Season 2 Wins")]),a("p",[e._v(" "+e._s(e.profileData.segments[0].stats.season2Wins.displayValue)+" "),a("span",[e._v("("+e._s(e.profileData.segments[0].stats.season2Wins.percentile)+")")])])]):e._e(),e.profileData.segments[0].stats.level?a("li",[a("h4",[e._v("Apex Level")]),a("p",[e._v(" "+e._s(e.profileData.segments[0].stats.level.displayValue)+" "),a("span",[e._v("("+e._s(e.profileData.segments[0].stats.level.percentile)+"%)")])])]):e._e(),e.profileData.segments[0].stats.kills?a("li",[a("h4",[e._v("Lifetime Kills")]),a("p",[e._v(" "+e._s(e.profileData.segments[0].stats.kills.displayValue)+" "),a("span",[e._v("("+e._s(e.profileData.segments[0].stats.kills.percentile)+"%)")])])]):e._e(),e.profileData.segments[0].stats.damage?a("li",[a("h4",[e._v("Damage Done")]),a("p",[e._v(" "+e._s(e.profileData.segments[0].stats.damage.displayValue)+" "),a("span",[e._v("("+e._s(e.profileData.segments[0].stats.damage.percentile)+"%)")])])]):e._e()])])]),a("router-link",{attrs:{to:"/"}},[e._v("Go Back")])],1):e._e()])},P=[],j=(a("96cf"),a("1da1")),k=a("bc3a"),S=a.n(k),C={name:"Profile",data:function(){return{loading:!1,error:null,profileData:null}},beforeCreate:function(){document.body.className="body-bg-no-image"},created:function(){var e=this;return Object(j["a"])(regeneratorRuntime.mark((function t(){var a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.loading=!0,t.prev=1,t.next=4,S.a.get("/api/v1/profile/".concat(e.$route.params.platform,"/").concat(e.$route.params.gamertag));case 4:a=t.sent,e.profileData=a.data.data,console.log(e.profileData),e.loading=!1,t.next=14;break;case 10:t.prev=10,t.t0=t["catch"](1),e.loading=!1,e.error=t.t0.response.data.message;case 14:case"end":return t.stop()}}),t,null,[[1,10]])})))()}},$=C,E=(a("0e48"),Object(u["a"])($,O,P,!1,null,"4ce6e9d0",null)),N=E.exports;r["a"].use(_["a"]);var L=new _["a"]({mode:"history",routes:[{path:"/",name:"search",component:w},{path:"/profile/:platform/:gamertag",name:"profile",component:N}]}),I=a("a65d"),M=a.n(I);r["a"].config.productionTip=!1,r["a"].use(M.a,{iconPack:"fontawesome"}),new r["a"]({router:L,render:function(e){return e(v)}}).$mount("#app")},"7a18":function(e,t,a){},"85ec":function(e,t,a){},"9e7b":function(e,t,a){"use strict";a("7a18")},cf05:function(e,t,a){e.exports=a.p+"img/logo.badc059d.png"},dc7b:function(e,t,a){}});
//# sourceMappingURL=app.b871f17a.js.map