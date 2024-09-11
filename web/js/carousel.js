//const wrapper = document.querySelector(".wrapper-list");
//const carousel = document.querySelector(".carousel-list");
//const firstCardWidth = carousel.querySelector(".card").offsetWidth;
//const arrowBtns = document.querySelectorAll(".wrapper i");
//const carouselChildrens = [...carousel.children];
//
//let isDragging = false, isAutoPlay = true, startX, startScrollLeft, timeoutId;
//
//// Get the number of cards that can fit in the carousel at once
//let cardPerView = Math.round(carousel.offsetWidth / firstCardWidth);  
//
//// Insert copies of the last few cards to beginning of carousel for infinite scrolling
//carouselChildrens.slice(-cardPerView).reverse().forEach(card => {
//    carousel.insertAdjacentHTML("afterbegin", card.outerHTML);
//});
//
//// Insert copies of the first few cards to end of carousel for infinite scrolling
//carouselChildrens.slice(0, cardPerView).forEach(card => {
//    carousel.insertAdjacentHTML("beforeend", card.outerHTML);
//});
//
//// Scroll the carousel at appropriate postition to hide first few duplicate cards on Firefox
//carousel.classList.add("no-transition");
//carousel.scrollLeft = carousel.offsetWidth;
//carousel.classList.remove("no-transition");
//
//// Add event listeners for the arrow buttons to scroll the carousel left and right
//arrowBtns.forEach(btn => {
//    btn.addEventListener("click", () => {
//        carousel.scrollLeft += btn.id == "left" ? -firstCardWidth : firstCardWidth;
//    });
//});
//
//const infiniteScroll = () => {
//    // If the carousel is at the beginning, scroll to the end
//    if (carousel.scrollLeft === 0) {
//        carousel.classList.add("no-transition");
//        carousel.scrollLeft = carousel.scrollWidth - (2 * carousel.offsetWidth);
//        carousel.classList.remove("no-transition");
//    }
//    // If the carousel is at the end, scroll to the beginning
//    else if (Math.ceil(carousel.scrollLeft) === carousel.scrollWidth - carousel.offsetWidth) {
//        carousel.classList.add("no-transition");
//        carousel.scrollLeft = carousel.offsetWidth;
//        carousel.classList.remove("no-transition");
//    }
//
//    // Clear existing timeout & start autoplay if mouse is not hovering over carousel
//    clearTimeout(timeoutId);
//    if (!wrapper.matches(":hover"))
//        autoPlay();
//}
//
//const autoPlay = () => {
//    if (window.innerWidth < 800 || !isAutoPlay)
//        return; // Return if window is smaller than 800 or isAutoPlay is false
//    // Autoplay the carousel after every 2500 ms
//    timeoutId = setTimeout(() => carousel.scrollLeft += firstCardWidth, 2500);
//}
//autoPlay();
//carousel.addEventListener("scroll", infiniteScroll);
//wrapper.addEventListener("mouseenter", () => clearTimeout(timeoutId));
//wrapper.addEventListener("mouseleave", autoPlay);

function initCarousel(wrapperSelector) {
    const wrapper = document.querySelector(wrapperSelector);
    const carousel = wrapper.querySelector(".carousel-list");
    const firstCardWidth = carousel.querySelector(".card").offsetWidth;
    const arrowBtns = wrapper.querySelectorAll("i");
    const carouselChildrens = [...carousel.children];

    let isDragging = false, isAutoPlay = true, startX, startScrollLeft, timeoutId;

    let cardPerView = Math.round(carousel.offsetWidth / firstCardWidth);

    carouselChildrens.slice(-cardPerView).reverse().forEach(card => {
        carousel.insertAdjacentHTML("afterbegin", card.outerHTML);
    });

    carouselChildrens.slice(0, cardPerView).forEach(card => {
        carousel.insertAdjacentHTML("beforeend", card.outerHTML);
    });

    carousel.classList.add("no-transition");
    carousel.scrollLeft = carousel.offsetWidth;
    carousel.classList.remove("no-transition");

    arrowBtns.forEach(btn => {
        btn.addEventListener("click", () => {
            carousel.scrollLeft += btn.id == "left" ? -firstCardWidth : firstCardWidth;
        });
    });

    const infiniteScroll = () => {
        if (carousel.scrollLeft === 0) {
            carousel.classList.add("no-transition");
            carousel.scrollLeft = carousel.scrollWidth - (2 * carousel.offsetWidth);
            carousel.classList.remove("no-transition");
        } else if (Math.ceil(carousel.scrollLeft) === carousel.scrollWidth - carousel.offsetWidth) {
            carousel.classList.add("no-transition");
            carousel.scrollLeft = carousel.offsetWidth;
            carousel.classList.remove("no-transition");
        }

        clearTimeout(timeoutId);
        if (!wrapper.matches(":hover"))
            autoPlay();
    }

    const autoPlay = () => {
        if (window.innerWidth < 800 || !isAutoPlay)
            return;
        timeoutId = setTimeout(() => carousel.scrollLeft += firstCardWidth, 2500);
    }

    autoPlay();
    carousel.addEventListener("scroll", infiniteScroll);
    wrapper.addEventListener("mouseenter", () => clearTimeout(timeoutId));
    wrapper.addEventListener("mouseleave", autoPlay);
}

// Khởi tạo từng carousel
initCarousel('.carousel-1');
initCarousel('.carousel-2');
initCarousel('.carousel-3');
