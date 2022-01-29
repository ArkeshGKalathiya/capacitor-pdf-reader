import { WebPlugin } from '@capacitor/core';
export class NGalaxyPDFReaderWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async openPDF(options) {
        console.log(options);
        return { value: "" };
    }
}
//# sourceMappingURL=web.js.map