class Carousel {

    /**
     * According to the carousel tutorial of Grafikart !
     */

    /**
     * This callback is displayed as part of the Requester class.
     * @callback moveCallback
     * @param {number} index
     */


    /**
     * 
     * @param {*} element 
     * @param {*} options 
     */


    /**
     * @param {HTMLElement} element 
     * @param {Object} option
     * @param {Object} option.slideToScroll Nombre d'élément à faire défiler;
     * @param {Object} option.slideVisible Nombre d'élément visible dans un slide;
     * @param {boolean} options.loop Doit-on boucler en fin de carousel;
     */
    constructor(element, options = {}) {
        this.element = element;
        this.options = Object.assign({}, {
            slideToScroll: 1,
            slideVisible: 1,
            loop: false
        }, options);
        
        let children = [].slice.call(element.children);
        this.isMobile = false;
        this.isTablette = false;
        this.currentItem = 0;
        this.root = this.createDivWithClass('carousel');
        this.container = this.createDivWithClass('carousel-container')
        
        this.root.appendChild(this.container);
        
        this.element.appendChild(this.root);

        this.moveCallbacks = []; 
        
        this.items = children.map((child) => {
            let item = this.createDivWithClass('carousel-item');
            item.appendChild(child);
            this.container.appendChild(item);
            return item;
        });

        this.setStyle();
        this.createNavigation();
        this.moveCallbacks.forEach(cb => cb(0));
        this.onWindowResize();
        window.addEventListener('resize', this.onWindowResize.bind(this))
    }

    /**
     * Applique les bons éléments au carousel
     */
    setStyle() {
        let ratio = this.items.length / this.slideVisible;
        this.container.style.width = (ratio * 100) + "%";
        this.items.forEach(item => item.style.width = ((100 / this.slideVisible) / ratio) + "%");
    }

    createNavigation() {
        let nextButton = this.createDivWithClass('carousel-next');
        let prevButton = this.createDivWithClass('carousel-prev');
        this.root.appendChild(nextButton);
        this.root.appendChild(prevButton);
        nextButton.addEventListener('click', this.next.bind(this));
        prevButton.addEventListener('click', this.prev.bind(this));

        if (this.options.loop == true) return;

        this.onMove(index => {
            if (index === 0) {
                prevButton.classList.add('carousel-prev--hidden');
            } else {
                prevButton.classList.remove('carousel-prev--hidden')
            }
            if (this.items[this.currentItem + this.slideVisible] === undefined) {
                nextButton.classList.add('carousel-next--hidden');
            } else {
                nextButton.classList.remove('carousel-next--hidden');
            }
        });        
    }

    next() {
        this.gotoItem(this.currentItem + this.slideToScroll);
    }

    prev () {
        this.gotoItem(this.currentItem - this.slideToScroll);
    }

    /**
     * Déplace le carousel vers l'élément ciblé.
     * @param {number} index 
     */
    gotoItem(index) {
        if (index < 0) {
            index = this.items.length - this.slideVisible;
        } else if (index >= this.items.length || this.items[this.currentItem + this.slideVisible] === undefined && index > this.currentItem) {
            index = 0;
        }

        let translateX = index * -100 / this.items.length;
        this.container.style.transform = 'translate3d(' + translateX + '%, 0, 0)';
        this.currentItem = index;
        this.moveCallbacks.forEach(cb => cb(index)); 
    }

    /**
     * 
     * @param {moveCallback} cb 
     */ 
    onMove(cb) {
        this.moveCallbacks.push(cb);
    }

    onWindowResize() {
        let mobile = window.innerWidth < 800;
        let tablette = window.innerWidth < 1200;

        if (mobile !== this.isMobile || tablette !== this.isTablette) {
            this.isMobile = mobile;
            this.isTablette = tablette;
            this.setStyle();
            this.moveCallbacks.forEach(cb => cb(this.currentItem));
        }
    }

    /**
     * 
     * @param {string} className
     * @returns {HTMLElement} 
     */
    createDivWithClass (className) {
        let div = document.createElement('div');
        div.setAttribute('class', className)
        return div;
    }

    /**
     * @returns {number}
     */
    get slideToScroll () {
        return this.isMobile ? 1 : this.isTablette && this.options.slideToScroll >= 2 ? 2 : this.options.slideToScroll;
    }

    /**
     * @returns {number}
     */
    get slideVisible () {
        return this.isMobile ? 1 : this.isTablette && this.options.slideVisible >= 2 ? 2 : this.options.slideVisible;
    }
}

document.addEventListener('DOMContentLoaded', function () {
    new Carousel(document.querySelector('#carousel1'), {
        slideVisible : 3,
        loop : true
    });
});
