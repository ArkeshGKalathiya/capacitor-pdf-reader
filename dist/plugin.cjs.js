'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const NGalaxyPDFReader = core.registerPlugin('NGalaxyPDFReader', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.NGalaxyPDFReaderWeb()),
});

class NGalaxyPDFReaderWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async openPDF(options) {
        console.log(options);
        return { value: "" };
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    NGalaxyPDFReaderWeb: NGalaxyPDFReaderWeb
});

exports.NGalaxyPDFReader = NGalaxyPDFReader;
//# sourceMappingURL=plugin.cjs.js.map
