export default class Tree {
  constructor(data) {
    this.data = { ...data };
    this.children = [];
  }

  insertNode(data) {
    let node = new Tree(data);
    this.children.push(node);
  }

  searchNode(data) {
    if (this.data != null && this.data.question_id == data.pre_question_id) {
      return this;
    }

    for (const child of this.children) {
      const cur = child.searchNode(data);
      if (cur) {
        return cur;
      }
    }
  }

  searchQuestion(data) {
    if (this.data != null && this.data.question_id == data.question_id) {
      return this;
    }

    for (const child of this.children) {
      const cur = child.searchQuestion(data);
      if (cur) {
        return cur;
      }
    }
  }
}
