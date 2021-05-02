import { Component, ViewEncapsulation } from '@angular/core';
import Keyboard from 'simple-keyboard';
  
@Component({
    selector: 'app-otp',
    encapsulation: ViewEncapsulation.None,
    templateUrl: './otp.component.html',
    styleUrls: ['../../../../node_modules/simple-keyboard/build/css/index.css', './otp.component.css']
})
export class OtpComponent {
    value = '';
    keyboard!: Keyboard;
    ngAfterViewInit() { }

    onInputFocus() {
      this.keyboard = new Keyboard({
        onChange: (input: string) => this.onChange(input),
        onKeyPress: (button: string) => this.onKeyPress(button)
      });
    }

    onChange = (input: string) => {
      this.value = input;
      console.log("Input changed", input);
    };
  
    onKeyPress = (button: string) => {
      console.log("Button pressed", button);
      if (button === "{shift}" || button === "{lock}") this.handleShift();
    };
  
    onInputChange = (event: any) => {
      this.keyboard.setInput(event.target.value);
    };
  
    handleShift = () => {
      let currentLayout = this.keyboard.options.layoutName;
      let shiftToggle = currentLayout === "default" ? "shift" : "default";
      this.keyboard.setOptions({
        layoutName: shiftToggle
      });
    };
}
