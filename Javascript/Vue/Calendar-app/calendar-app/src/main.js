import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import VueTextareaAutosize from 'vue-textarea-autosize'; 
import firebase from 'firebase/app';
import 'firebase/firestore';

Vue.use(VueTextareaAutosize);
Vue.config.productionTip = false

firebase.initializeApp({
    apiKey: "AIzaSyBRZAbqpTNg5-VTosQ9UGSAdG8F7k-sL2Q",
    authDomain: "vue-calendar-53b64.firebaseapp.com",
    databaseURL: "https://vue-calendar-53b64-default-rtdb.firebaseio.com",
    projectId: "vue-calendar-53b64",
    storageBucket: "vue-calendar-53b64.appspot.com",
    messagingSenderId: "445798299277",
    appId: "1:445798299277:web:cc9c9b2818f1f269ed14c4"
});

export const db = firebase.firestore();

new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
