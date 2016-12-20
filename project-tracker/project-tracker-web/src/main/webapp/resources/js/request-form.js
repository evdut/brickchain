var msieversion = function() {
	var ua = window.navigator.userAgent;
	if (ua.indexOf("MSIE ") > 0) {
		return true;
	} else if (ua.indexOf('Trident/') > 0) {
		return true;
	} else if (ua.indexOf('Edge/') > 0) {
		return true;
	}

	return false;
};
function loadjscssfile(filename, filetype) {
	if (filetype == "js") { // if filename is a external JavaScript file
		var fileref = document.createElement('script');
		fileref.setAttribute("type", "text/javascript");
		fileref.setAttribute("src", filename);
	} else if (filetype == "css") { // if filename is an external CSS file
		var fileref = document.createElement("link");
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", filename);
	}
	if (typeof fileref != "undefined")
		document.getElementsByTagName("head")[0].appendChild(fileref);
};
(function($) {
	var autoType = function(elem, options) {

		var stringToType = options.string, hideElements = options.hideElements,
		curStrPos = 1,
		typeSpeed = options.typeSpeed, interrupt = false,
		nextString;

		var startTyping = function() {
			if (hideElements != null) {
				hideElements.forEach(function(hideElement) {
					hideElement.css('display', 'none');
				});
			}
			elem.append('<div class="autotype"></div>');
			frameLooper();
		};

		var stopTyping = function() {
			interrupt = true;
		};

		function frameLooper() {
			var humanize = Math.round(Math.random() * 70) + typeSpeed;
			if (interrupt) {
				elem.children('.autotype').remove();
				return;			
			} else if (curStrPos < stringToType.length) {
				nextString = stringToType.substr(0, curStrPos);
				elem.children('.autotype').text(nextString);
				curStrPos++;
			} else {
				if (hideElements != null) {
					setTimeout(function() {
						elem.children('.autotype').remove();
						hideElements.forEach(function(hideElement) {
							hideElement.css('display', 'block');
						});}, 2000);
				}
				return false;
			}
			
			setTimeout(function(){ frameLooper(); }, humanize);
		}

		return {
			startTyping : startTyping,
			stopTyping : stopTyping
		};
	};

	$.fn.autotype = function(options) {
		var options = $.extend({}, $.fn.autotype.defaults, options);
		return autoType(this, options);
	};

	$.fn.autotype.defaults = {
		string : "I need to install...",
		strings : "I need to install...",
		typeSpeed : 50,
		/*
		 * Array of elements which need to be hidden while autotyping
		 */
		hideElements : null
	};
})(jQuery);

// ////////////////////////////
$(window).load(
		function() {

			var editorZone = $("#editorZone");

			var myDropzone = editorZone.dropzone({
				url : "/file/post",
				clickable : false
			});
			editorZone.addClass('dropzone');
			
			var notebook = editorZone.notebook({
				placeholder:"",
		        modifiers: ['bold', 'italic', 'underline', 'ol', 'ul', 'anchor']
			});
			/////sortable
			var sortableOptions = {
					placeholder : 'ui-state-highlight',
					dropOnEmpty : true,
					delay: 150,
					tolerance: "pointer",
					zIndex: 1001,
					opacity: 0.7,
					cursor: "move",
					cursorAt: { left: 35, top:35 },
					start:function(ev, ui) {
						$(".ui-state-highlight").addClass("begin");
						ui.item.addClass("sorting");
				    },
					change : function(ev, ui) {
						$(".ui-state-highlight").removeClass("ready");
				        $(".ui-state-highlight").addClass("ready", 500, "easeOutCirc");
				        
				    },
				    stop : function(ev, ui) {
				    	ui.item.removeClass("sorting");
				    }	
				};
			
			editorZone.sortable( $.extend({}, sortableOptions, 
					{connectWith : '.subEditor', cancel : 'div#editorZone > *:not(.dz-preview)'}
			));
			
			$(document).on("listAddedEvent",
					function(event, element, subelement) {
						var numberOfElements = $(element.tagName).length;
						$(element).addClass("subEditor");
						$(element).addClass("subEditor" + numberOfElements);
		
						$('.subEditor' + numberOfElements).sortable($.extend({}, sortableOptions, 
								{connectWith : '#editorZone', cancel : 'li'}
						));
					});
			///////////////////
			
			////////////////
			var stateHighlight = $(document.createElement('div'));
			var dragHoverElement;
			var counter = 0;
			stateHighlight.addClass("ui-state-highlight");
			stateHighlight.addClass("begin");
			myDropzone.on("dragover", function(e) {
				
				if (dragHoverElement != e.target && !$(e.target).hasClass('ui-state-highlight')) {
					dragHoverElement = e.target;
					
					if ($(dragHoverElement).parent().hasClass('ui-sortable')) {
						stateHighlight.removeClass("ready");
						stateHighlight.detach();
						$(dragHoverElement).after(stateHighlight);
						stateHighlight.show();
						stateHighlight.addClass("ready", 500, "easeOutCirc");
					} else if ($(dragHoverElement).closest(".dz-preview").length > 0) {
						
						var dragHoverParent = $(dragHoverElement).closest(".dz-preview");
						var offset = dragHoverParent.offset();
						var relX = e.originalEvent.clientX - offset.left;
						
						stateHighlight.removeClass("ready");
						stateHighlight.detach();
						if(relX < dragHoverParent.width()/2) {
							$(dragHoverParent).before(stateHighlight);
						} else {
							$(dragHoverParent).after(stateHighlight);
						}
						
						stateHighlight.show();
						stateHighlight.addClass("ready", 500, "easeOutCirc");
					} else if ($(dragHoverElement).hasClass('ui-sortable')) {
						stateHighlight.prependTo($(dragHoverElement));
					}
					
				}
				
			});
			myDropzone.on("drop", function(e) {
				stateHighlight.hide();
				var addedPreview = $(this).children().last();
				addedPreview.attr('contenteditable', false);
				addedPreview.detach();
				addedPreview.insertAfter(stateHighlight);
				var nextElements = addedPreview.nextAll("*:not(.placeholder)");
				if(nextElements.length <= 0) {
					var br = document.createElement('br');
					var f = document.createTextNode("\n");
					addedPreview.after($(f));
					$(f).focusfff(f);
					notebook.trigger({type: 'keydown', which: 13, keyCode: 13});
				}
				stateHighlight.detach();
				counter = 0;
			});
			
			
			myDropzone.on("dragleave", function(e) {	
				setTimeout(function() {
					counter--;
                    if (counter === 0) {
                    	stateHighlight.hide();
                    }
				}, 50);
			});
			
			myDropzone.on("dragenter", function(e) {
				counter++;
			});
			
			
			var input = document.querySelector('input[type=file]'); 
			input.onchange = function() {
				var file = input.files[0];

				displayAsImage(file); 
			};

			function displayAsImage(file) {
				var imgURL = URL.createObjectURL(file), img = document
						.getElementById("myimg");

				img.onload = function() {
					URL.revokeObjectURL(imgURL);
				};

				img.src = imgURL;

			}
			
			var autoType = $('#editorZone').autotype({
				string:'I need to:\n install pod lights in my living room \n make wiring ',
				hideElements : [ $('#editorZone').children(".placeholder") ]
			});
			
			$('#editorZone').on("mousedown", function() {
				autoType.stopTyping();
			});
			autoType.startTyping();
		});