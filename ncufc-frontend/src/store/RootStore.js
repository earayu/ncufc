import { observable } from "mobx"
import UIStore from './UIStore'
import Config from './Config'
import HomeStore from "./HomeStore";

class RootStore {
    constructor() {
        this.uiStore = new UIStore(this)
        this.config = new Config(this)
        this.homeStore = new HomeStore(this)
    }
}

let rootStore = new RootStore();

//TODO delete
window.store = rootStore.uiStore
window.homeStore = rootStore.homeStore
export default rootStore;
