class CurriculumsController < ApplicationController

  def index
    @curriculums = Curriculum.all
  end

  def new
    @curriculum = Curriculum.new
  end

  def show
    @curriculum = Curriculum.find(params[:id])
  end

end
