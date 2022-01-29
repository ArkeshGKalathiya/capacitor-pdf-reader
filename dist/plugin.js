var capacitorNGalaxyPDFReader = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
