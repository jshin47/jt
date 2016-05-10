webpackJsonp([7],{

/***/ 0:
/***/ function(module, exports, __webpack_require__) {

	var Spinner = __webpack_require__(1617);

	__webpack_require__(1618)

	window.Spinner = Spinner;

/***/ },

/***/ 1617:
/***/ function(module, exports, __webpack_require__) {

	(function webpackUniversalModuleDefinition(root, factory) {
		if(true)
			module.exports = factory(__webpack_require__(55));
		else if(typeof define === 'function' && define.amd)
			define(["react"], factory);
		else if(typeof exports === 'object')
			exports["Spinner"] = factory(require("react"));
		else
			root["Spinner"] = factory(root["React"]);
	})(this, function(__WEBPACK_EXTERNAL_MODULE_1__) {
	return /******/ (function(modules) { // webpackBootstrap
	/******/ 	// The module cache
	/******/ 	var installedModules = {};
	/******/
	/******/ 	// The require function
	/******/ 	function __webpack_require__(moduleId) {
	/******/
	/******/ 		// Check if module is in cache
	/******/ 		if(installedModules[moduleId])
	/******/ 			return installedModules[moduleId].exports;
	/******/
	/******/ 		// Create a new module (and put it into the cache)
	/******/ 		var module = installedModules[moduleId] = {
	/******/ 			exports: {},
	/******/ 			id: moduleId,
	/******/ 			loaded: false
	/******/ 		};
	/******/
	/******/ 		// Execute the module function
	/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
	/******/
	/******/ 		// Flag the module as loaded
	/******/ 		module.loaded = true;
	/******/
	/******/ 		// Return the exports of the module
	/******/ 		return module.exports;
	/******/ 	}
	/******/
	/******/
	/******/ 	// expose the modules object (__webpack_modules__)
	/******/ 	__webpack_require__.m = modules;
	/******/
	/******/ 	// expose the module cache
	/******/ 	__webpack_require__.c = installedModules;
	/******/
	/******/ 	// __webpack_public_path__
	/******/ 	__webpack_require__.p = "./build";
	/******/
	/******/ 	// Load entry module and return exports
	/******/ 	return __webpack_require__(0);
	/******/ })
	/************************************************************************/
	/******/ ([
	/* 0 */
	/***/ function(module, exports, __webpack_require__) {

		'use strict';
		
		Object.defineProperty(exports, '__esModule', {
		  value: true
		});
		
		var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
		
		function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { 'default': obj }; }
		
		var _react = __webpack_require__(1);
		
		var _react2 = _interopRequireDefault(_react);
		
		var Spinner = _react2['default'].createClass({
		  displayName: 'Spinner',
		
		  render: function render() {
		    var bars = [];
		    var props = this.props;
		
		    for (var i = 0; i < 12; i++) {
		      var barStyle = {};
		      barStyle.WebkitAnimationDelay = barStyle.animationDelay = (i - 12) / 10 + 's';
		
		      barStyle.WebkitTransform = barStyle.transform = 'rotate(' + i * 30 + 'deg) translate(146%)';
		
		      bars.push(_react2['default'].createElement('div', { style: barStyle, className: 'react-spinner_bar', key: i }));
		    }
		
		    return _react2['default'].createElement(
		      'div',
		      _extends({}, props, { className: (props.className || '') + ' react-spinner' }),
		      bars
		    );
		  }
		});
		
		exports['default'] = Spinner;
		module.exports = exports['default'];

	/***/ },
	/* 1 */
	/***/ function(module, exports) {

		module.exports = __WEBPACK_EXTERNAL_MODULE_1__;

	/***/ }
	/******/ ])
	});
	;
	//# sourceMappingURL=index.map

/***/ },

/***/ 1618:
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(1619);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(267)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(false) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept("!!./../css-loader/index.js!./react-spinner.css", function() {
				var newContent = require("!!./../css-loader/index.js!./react-spinner.css");
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 1619:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(266)();
	// imports


	// module
	exports.push([module.id, ".react-spinner {\n  position: relative;\n  width: 32px;\n  height: 32px;\n  top: 50%;\n  left: 50%;\n}\n\n.react-spinner_bar {\n  -webkit-animation: react-spinner_spin 1.2s linear infinite;\n  -moz-animation: react-spinner_spin 1.2s linear infinite;\n  animation: react-spinner_spin 1.2s linear infinite;\n  border-radius: 5px;\n  background-color: white;\n  position: absolute;\n  width: 20%;\n  height: 7.8%;\n  top: -3.9%;\n  left: -10%;\n}\n\n@keyframes react-spinner_spin {\n 0% { opacity: 1; }\n 100% { opacity: 0.15; }\n}\n\n@-moz-keyframes react-spinner_spin {\n 0% { opacity: 1; }\n 100% { opacity: 0.15; }\n}\n\n@-webkit-keyframes react-spinner_spin {\n 0% { opacity: 1; }\n 100% { opacity: 0.15; }\n}\n", ""]);

	// exports


/***/ }

});