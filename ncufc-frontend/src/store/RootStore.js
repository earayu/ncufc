import { observable } from "mobx"
import UIStore from './UIStore'

class RootStore {
    constructor() {
        this.uiStore = new UIStore(this)
    }
}

let rootStore = new RootStore();

export default rootStore;
