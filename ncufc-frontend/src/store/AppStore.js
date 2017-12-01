import { observable, autorun } from "mobx";

export class AppStore{
    clicking = observable(false)
}

var store = new AppStore();

export default store;

autorun (()=>{
    console.log(store.clicking)
})