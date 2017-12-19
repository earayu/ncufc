import { observable } from "mobx"
import UIStore from './UIStore'
import Config from './Config'

class RootStore {
    constructor() {
        this.uiStore = new UIStore(this)
        this.config = new Config(this)
    }
}

let rootStore = new RootStore();
window.store = rootStore.uiStore
export default rootStore;
